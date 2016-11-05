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
        Task1110 solver = new Task1110();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1110 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt(), y = in.nextInt();
            y %= m;
            boolean first = true;
            for (int i = 0; i < m; ++i) {
                if (fastpowmod(i, n, m) == y) {
                    if (!first) out.print(" ");
                    first = false;
                    out.print(i);
                }
            }
            if (first) out.print("-1");
            out.println();
        }

        private int fastpowmod(int b, int e, int m) {
            if (e == 0) return 1;
            if (e == 1) return b;
            int tmp = fastpowmod((b * b) % m, e / 2, m);
            if (e % 2 == 1) return (b * tmp) % m;
            return tmp;
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

