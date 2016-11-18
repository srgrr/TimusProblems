import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task1777 solver = new Task1777();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1777 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            ArrayList<Long> v = new ArrayList<>();
            for (int i = 0; i < 3; ++i) v.add(in.nextLong());
            Collections.sort(v);
            int ans = 0;
            long newv = 1100000000000000000L;
            while (newv != 0L) {
                ++ans;
                newv = 1100000000000000000L;
                for (int i = 1; i < v.size(); ++i)
                    newv = Math.min(newv, v.get(i) - v.get(i - 1));
                v.add(newv);
                Collections.sort(v);
            }
            out.println(ans);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            String CR = "Class taken from Petr Mitrichev's source code";
            reader = new BufferedReader(new InputStreamReader(stream), 65536 / 2);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

