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
        Task1118 solver = new Task1118();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1118 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long[] divSum = new long[1000009];
            for (int i = 1; i <= 1000000; ++i) {
                for (int j = i; j <= 1000000; j += i) divSum[j] += (long) i;
            }
            int l = in.nextInt(), r = in.nextInt();
            double ans = 1e80;
            int argmin = 0;
            for (int i = l; i <= r; ++i) {
                double rat = (double) divSum[i] / (double) i;
                if (rat < ans) {
                    ans = rat;
                    argmin = i;
                }
            }
            out.println(argmin);
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

