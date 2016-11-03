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
        Task1009 solver = new Task1009();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1009 {
        int _calc(int[][] dp, int n, int d, int b) {
            if (n == 0) return 1;
            if (dp[n][d] != -1) return dp[n][d];
            if (d == 0) {
                dp[n][d] = (b - 1) * _calc(dp, n - 1, 0, b) + _calc(dp, n - 1, 1, b);
            } else {
                dp[n][d] = (b - 1) * _calc(dp, n - 1, 0, b);
            }
            return dp[n][d];
        }

        int calc(int b, int n) {
            int[][] dp = new int[n + 2][2];
            for (int i = 0; i <= n; ++i)
                dp[i][0] = dp[i][1] = -1;
            return _calc(dp, n, 0, b);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            out.println((k - 1) * calc(k, n - 1));
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
