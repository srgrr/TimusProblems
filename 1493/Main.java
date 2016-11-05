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
        Task1493 solver = new Task1493();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1493 {
        private boolean isLucky(int inp) {
            String x = String.valueOf(inp);
            while (x.length() < 6) x = "0" + x;
            int s1 = 0;
            for (int i = 0; i < 3; ++i) s1 += (int) x.charAt(i);
            int s2 = 0;
            for (int i = 3; i < 6; ++i) s2 += (int) x.charAt(i);
            return s1 == s2;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int x = in.nextInt();
            if (isLucky(x - 1) || isLucky(x + 1)) out.println("Yes");
            else out.println("No");
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

