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
        Task1020 solver = new Task1020();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1020 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            double r = in.nextDouble();
            double[] x = new double[n], y = new double[n];
            for (int i = 0; i < n; ++i) {
                x[i] = in.nextDouble();
                y[i] = in.nextDouble();
            }
            double ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += dist(x[i], y[i], x[(i + 1) % n], y[(i + 1) % n]);
            }
            ans += 2.0 * Math.PI * r;
            out.printf("%.02f\n", ans);
        }

        private double dist(double x1, double y1, double x2, double y2) {
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}

