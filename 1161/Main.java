import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;
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
        Task1161 solver = new Task1161();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1161 {
        private int n;
        private int[] v;
        private double[] dp;

        private double calc(int ix) {
            if (ix == n - 1) return (double) v[ix];
            if (ix == n - 2) return 2.0 * Math.sqrt(v[ix] * v[ix + 1]);
            if (dp[ix] > 1e80) {
                dp[ix] = 2.0 * Math.sqrt(2.0 * Math.sqrt(v[ix] * v[ix + 1]) * calc(ix + 2));
                dp[ix] = Math.min(dp[ix], 2.0 * Math.sqrt(v[ix] * calc(ix + 1)));
            }
            return dp[ix];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            v = new int[n];
            for (int i = 0; i < n; ++i) v[i] = in.nextInt();
            SafeSort.sort(v);
            dp = new double[n];
            for (int i = 0; i < n; ++i) dp[i] = 1e90;
            out.printf("%.02f\n", calc(0));
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

    static class SafeSort {
        public static void sort(int[] arr) {
            Random random = new Random();
            for (int i = 0; i < arr.length; ++i) {
                int i1 = Math.abs(random.nextInt()) % arr.length;
                int i2 = Math.abs(random.nextInt()) % arr.length;
                int tmp = arr[i1];
                arr[i1] = arr[i2];
                arr[i2] = tmp;
            }
            Arrays.sort(arr);
        }

    }
}

