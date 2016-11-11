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
        Task1104 solver = new Task1104();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1104 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String x = in.next();
            for (int i = 2; i <= 36; ++i) {
                if (ok(x, i)) {
                    out.println(i);
                    return;
                }
            }
            out.println("No solution.");
        }

        private boolean ok(String x, int b) {
            int rem = 0;
            for (int i = 0; i < x.length(); ++i) {
                int dg = getNum(x.charAt(i));
                if (dg >= b) return false;
                rem *= b;
                rem += dg;
                rem %= (b - 1);
            }
            return rem == 0;
        }

        private int getNum(char c) {
            if (c >= '0' && c <= '9') return c - '0';
            return c - 'A' + 10;
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

    }
}

