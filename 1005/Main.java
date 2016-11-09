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
        Task1005 solver = new Task1005();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1005 {
        private static final int maxn = 20;
        private static final int maxw = 100000;
        private static final int zero = maxn * maxw;
        private static final int inf = 1000000000;
        private static int[] v = new int[maxn];
        private static boolean[][] dp = new boolean[2][2 * zero + 3];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) v[i] = in.nextInt();
            int cur = 0;
            dp[0][zero] = true;
            for (int i = 0; i < n; ++i) {
                cur = 1 - cur;
                for (int j = v[i]; j + v[i] < 2 * zero + 3; ++j)
                    dp[cur][j] = dp[1 - cur][j - v[i]] || dp[1 - cur][j + v[i]];
            }
            int ans = inf;
            for (int i = 0; i < 2 * zero + 3; ++i)
                if (dp[cur][i]) ans = Math.min(ans, Math.abs(i - zero));
            out.println(ans);
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

