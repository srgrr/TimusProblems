import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.HashMap;
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
        Task1496 solver = new Task1496();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1496 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            HashMap<String, Integer> S = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                String x = in.next();
                if (!S.containsKey(x)) S.put(x, 1);
                else S.put(x, S.get(x) + 1);
            }
            S.keySet().stream().filter(x -> S.get(x) > 1).forEach(out::println);
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

