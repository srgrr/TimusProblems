import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
        Task1642 solver = new Task1642();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1642 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), x = in.nextInt();
            TreeSet<Integer> S = new TreeSet<>();
            S.add(x);
            for (int i = 0; i < n; ++i) S.add(in.nextInt());
            if (S.floor(0) != x && S.ceiling(0) != x) {
                out.println("Impossible");
                return;
            }
            int forw = Math.abs(S.ceiling(0) - x) + Math.abs(S.ceiling(0));
            int back = Math.abs(S.floor(0) - x) + Math.abs(S.floor(0));
            out.println(forw + " " + back);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

