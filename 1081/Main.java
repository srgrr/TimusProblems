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
        Task1081 solver = new Task1081();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1081 {
        int n;
        long ix;
        long[] dp = new long[45];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < 45; ++i) dp[i] = dp[i - 1] + dp[i - 2];
            n = in.nextInt();
            ix = in.nextLong();
            if (ix > dp[n]) {
                out.println("-1");
                return;
            }
            int last = 0;
            for (int i = n; i > 0; --i) {
                if (last == 1) {
                    out.print("0");
                    last = 0;
                } else {
                    if (dp[i - 1] < ix) {
                        out.print("1");
                        ix -= dp[i - 1];
                        last = 1;
                    } else {
                        out.print("0");
                    }
                }
            }
            out.println();
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
