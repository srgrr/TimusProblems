import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Task2018 solver = new Task2018();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2018 {
        private final static int maxab = 700;
        private final static int modulo = 1000000007;
        private final static int zero = 305;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            int[][] ans = new int[2][maxab];
            int cur = 0;
            ans[cur][zero] = 1;
            for (int i = 0; i < n; ++i) {
                Arrays.fill(ans[1 - cur], 0);
                for (int j = zero - a; j < zero; ++j) {
                    ans[1 - cur][j] = ans[cur][j + 1];
                }
                for (int j = zero + 1; j <= zero + b; ++j) {
                    ans[1 - cur][j] = ans[cur][j - 1];
                }
                for (int j = zero + 1; j <= zero + b; ++j) {
                    ans[1 - cur][zero - 1] += ans[cur][j];
                    ans[1 - cur][zero - 1] %= modulo;
                }
                for (int j = zero - a; j < zero; ++j) {
                    ans[1 - cur][zero + 1] += ans[cur][j];
                    ans[1 - cur][zero + 1] %= modulo;
                }
                cur = 1 - cur;
            }
            int ret = 0;
            for (int i = zero - a; i <= zero + b; ++i)
                ret = (ret + ans[cur][i]) % modulo;
            out.println(ret);
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

