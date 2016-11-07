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
        Task1025 solver = new Task1025();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1025 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; ++i) v[i] = in.nextInt();
            SafeSort.sort(v);
            int ans = 0;
            for (int i = 0; i <= n / 2; ++i) ans += v[i] / 2 + 1;
            out.println(ans);
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

