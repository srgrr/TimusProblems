import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        Task2025 solver = new Task2025();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2025 {
        private long nc2(long x) {
            return x * (x - 1L) / 2L;
        }

        private long calc(long n, long k) {
            long fg = n / k; // fighters per group
            long p1 = n % k; // groups with fg + 1 fighters
            long p2 = k - p1; // groups with fg fighters
            //System.err.println(fg + " " + p1 + " " + p2 + " " + (fg*nc2(p2)));
            return fg * (fg + 1L) * p1 * p2 + fg * fg * nc2(p2) + (fg + 1L) * (fg + 1L) * nc2(p1);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while (T-- > 0) {
                long n = in.nextLong(), k = in.nextLong();
                long ans = calc(n, k);
                out.println(ans);
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

