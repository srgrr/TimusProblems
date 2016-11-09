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
        Task1638 solver = new Task1638();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1638 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int vol = in.nextInt(), book = in.nextInt(), l = in.nextInt(), r = in.nextInt();
            int amount = Math.max(r, l) - Math.min(l, r) + 1;
            int ans = 0;
            if (l < r) {
                ans = Math.max(amount * vol - 2 * vol, 0) + 2 * book * (amount - 1);
            } else if (l == r) {
                ans = vol;
            } else {
                ans = vol * amount + 2 * book * amount - 2 * book;
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

