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
        Task1139 solver = new Task1139();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1139 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt() - 1, m = in.nextInt() - 1;
            if (n == 0 || m == 0) {
                out.println(0);
                return;
            }
            if (n == m) {
                out.println(n);
                return;
            }
            if (n > m) {
                int tmp = n;
                n = m;
                m = tmp;
            }
            int ans = m;
            double EPSILON = 1e-9;
            double slope = (double) n / (double) m;
            for (int i = 1; i < m; ++i) {
                double fi = slope * (double) (i) - EPSILON;
                double fi1 = slope * (double) (i - 1) + EPSILON;
                int qfi = (int) fi;
                int qfi1 = (int) fi1;
                if (qfi > qfi1) {
                    ++ans;
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

