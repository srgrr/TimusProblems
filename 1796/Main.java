import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        Task1796 solver = new Task1796();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1796 {
        private static int[] values = new int[]{10, 50, 100, 500, 1000, 5000};

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int[] v = new int[6];
            int total = 0, minValue = 92139195;
            for (int i = 0; i < 6; ++i) {
                v[i] = in.nextInt();
                total += values[i] * v[i];
                if (v[i] > 0) minValue = Math.min(minValue, values[i]);
            }
            int p = in.nextInt();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i <= 6660000; ++i) {
                if ((long) p * (long) i <= (long) total && (long) p * (long) i > (long) total - (long) minValue)
                    ans.add(i);
            }
            out.println(ans.size());
            for (int i = 0; i < ans.size(); ++i) {
                if (i > 0) out.print(" ");
                out.print(ans.get(i));
            }
            out.println();
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

