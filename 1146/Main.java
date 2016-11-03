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
        Task1146 solver = new Task1146();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1146 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] v = new int[n][n];
            for (int i = 0; i < n; ++i) {
                v[i][0] = in.nextInt();
                for (int j = 1; j < n; ++j)
                    v[i][j] = v[i][j - 1] + in.nextInt();
            }
            int ans = -999999;
            for (int i = 0; i < n; ++i) {
                for (int j = i; j < n; ++j) {
                    int sum = 0;
                    for (int k = 0; k < n; ++k) {
                        int elem = v[k][j] - (i == 0 ? 0 : v[k][i - 1]);
                        if (sum < 0) sum = elem;
                        else sum += elem;
                        ans = Math.max(ans, sum);
                    }
                }
            }
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
