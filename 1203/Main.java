import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        Task1203 solver = new Task1203();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1203 {
        private ArrayList<Integer>[] it = new ArrayList[30009];
        private int[] dp = new int[30009];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            for (int i = 0; i < 30009; ++i) it[i] = new ArrayList<>();
            for (int i = 0; i < n; ++i) it[in.nextInt()].add(in.nextInt());
            Arrays.fill(dp, -1);
            int ans = calc(0);
            out.println(ans);
        }

        private int calc(int x) {
            if (x == 30008) return 0;
            if (dp[x] == -1) {
                dp[x] = calc(x + 1);
                for (int i = 0; i < it[x].size(); ++i)
                    dp[x] = Math.max(dp[x], 1 + calc(it[x].get(i) + 1));
            }
            return dp[x];
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

