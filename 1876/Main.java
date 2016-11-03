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
        Task1876 solver = new Task1876();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1876 {
        static short[][][][] dp = new short[41][41][101][101];

        private short calc(int l, int r, int a, int b) {
            if (l == 0 && r == 0) return 0;
            if (dp[l][r][a][b] == -1) {
                if (l > 0) {
                    if (a > 0) dp[l][r][a][b] = (short) Math.max(dp[l][r][a][b], 1 + calc(l - 1, r, a - 1, b));
                    if (b > 0)
                        dp[l][r][a][b] = (short) Math.max(dp[l][r][a][b], 2 + calc(l, Math.max(0, r - 1), a, b - 1));
                } else {
                    if (a > 0) dp[l][r][a][b] = (short) Math.max(dp[l][r][a][b], 2 + calc(0, r, a - 1, b));
                    if (b > 0) dp[l][r][a][b] = (short) Math.max(dp[l][r][a][b], 1 + calc(0, r - 1, a, b - 1));
                }
            }
            return dp[l][r][a][b];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 0; i < 41; ++i)
                for (int j = 0; j < 41; ++j)
                    for (int k = 0; k < 101; ++k)
                        for (int l = 0; l < 101; ++l)
                            dp[i][j][k][l] = -1;
            int a = in.nextInt(), b = in.nextInt();
            out.println(calc(40, 40, a, b));
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

