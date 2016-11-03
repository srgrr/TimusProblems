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
        Task1313 solver = new Task1313();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1313 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j) m[i][j] = in.nextInt();
            boolean first = true;
            int fi = 0, fj = 0;
            while (fj < n) {
                int i = fi, j = fj;
                while (i >= 0 && j < n) {
                    if (!first) out.print(" ");
                    out.print(m[i][j]);
                    first = false;
                    --i;
                    ++j;
                }
                if (fi == n - 1) ++fj;
                fi = Math.min(fi + 1, n - 1);

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

    }
}

