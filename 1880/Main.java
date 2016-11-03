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
        Task1880 solver = new Task1880();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1880 {
        int[] n = new int[2];
        int[][] values = new int[2][4009];

        private boolean in(int[] value, int l, int r, int x) {
            if (l <= r) {
                int h = (l + r) / 2;
                if (value[h] == x) return true;
                if (value[h] < x) return in(value, h + 1, r, x);
                return in(value, l, h - 1, x);
            }
            return false;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 0; i < 2; ++i) {
                n[i] = in.nextInt();
                for (int j = 0; j < n[i]; ++j) values[i][j] = in.nextInt();
            }
            int ans = 0;
            int nf = in.nextInt();
            for (int i = 0; i < nf; ++i) {
                int x = in.nextInt();
                boolean all = true;
                for (int j = 0; j < 2; ++j)
                    all &= in(values[j], 0, n[j] - 1, x);
                if (all) ++ans;
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

