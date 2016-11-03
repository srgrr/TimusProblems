import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sergioRG
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task1209 solver = new Task1209();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1209 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Set<Integer> S = new HashSet<>();
            int p = 1, dg = 1;
            while (p > 0) {
                S.add(p);
                p += dg;
                ++dg;
            }
            int T = in.nextInt();
            boolean first = true;
            for (int i = 0; i < T; ++i) {
                int x = in.nextInt();
                if (!first) out.print(" ");
                first = false;
                if (S.contains(x)) out.print(1);
                else out.print(0);
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

