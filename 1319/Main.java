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
        Task1319 solver = new Task1319();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1319 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] ans = new int[n][n];
            int cur = 1;
            int fi = 0, fj = n - 1;
            while (!(fi == n - 1 && fj == 0)) {
                int i = fi, j = fj;
                while (i < n && j < n) {
                    ans[i][j] = cur;
                    ++cur;
                    ++i;
                    ++j;
                }
                if (fj == 0) ++fi;
                fj = Math.max(0, fj - 1);
            }
            ans[n - 1][0] = n * n;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (j > 0) out.print(" ");
                    out.print(ans[i][j]);
                }
                out.println();
            }
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

