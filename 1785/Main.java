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
        Task1785 solver = new Task1785();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1785 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int x = in.nextInt();
            int[] l = new int[]{1, 5, 10, 20, 50, 100, 250, 500, 1000, 2009};
            String[] ans = new String[]{"few", "several", "pack", "lots", "horde", "throng",
                    "swarm", "zounds", "legion", "rickroll"};
            for (int i = 0; i < l.length; ++i) {
                if (x >= l[i] && x < l[i + 1]) {
                    out.println(ans[i]);
                    return;
                }
            }
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

