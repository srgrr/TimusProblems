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
        Task1225 solver = new Task1225();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1225 {
        long[][] dp = new long[46][2];

        long calc(int pos, int last) {
            if (pos < 0) return 0L;
            if (pos == 0) return 1L;
            if (dp[pos][last] == -1L) {
                dp[pos][last] = 0L;
                if (last == 1) dp[pos][last] += calc(pos - 1, 0) + calc(pos - 2, 0);
                if (last == 0) dp[pos][last] += calc(pos - 1, 1) + calc(pos - 2, 1);
            }
            return dp[pos][last];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 0; i < 46; ++i)
                for (int j = 0; j < 2; ++j)
                    dp[i][j] = -1L;
            int n = in.nextInt() - 1;
            out.println(calc(n, 0) + calc(n, 1));
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

