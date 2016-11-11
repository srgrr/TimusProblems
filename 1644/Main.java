import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
        Task1644 solver = new Task1644();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1644 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            TreeSet<Integer> sat = new TreeSet<>(), hun = new TreeSet<>();
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                int x = in.nextInt();
                String t = in.next();
                if (t.equals("hungry")) hun.add(x);
                else sat.add(x);
                if ((t.equals("hungry") && sat.floor(x) != null) || (!t.equals("hungry") && hun.ceiling(x) != null)) {
                    out.println("Inconsistent");
                    return;
                }
            }
            int ans = !sat.isEmpty() ? sat.first() : 10;
            out.println(ans);
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

