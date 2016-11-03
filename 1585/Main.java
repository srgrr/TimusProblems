import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        Task1585 solver = new Task1585();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1585 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashMap<String, Integer> freqs = new HashMap<>();
            freqs.put("Emperor", 0);
            freqs.put("Little", 0);
            freqs.put("Macaroni", 0);
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                String x = in.nextLine().split(" ")[0];
                freqs.put(x, freqs.get(x) + 1);
            }
            int e = freqs.get("Emperor"), l = freqs.get("Little"), m = freqs.get("Macaroni");
            int mx = Math.max(e, Math.max(l, m));
            if (e == mx) out.println("Emperor Penguin");
            else if (l == mx) out.println("Little Penguin");
            else out.println("Macaroni Penguin");
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

