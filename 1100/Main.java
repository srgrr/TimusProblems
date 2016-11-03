import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        Task1100 solver = new Task1100();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1100 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Pair[] v = new Pair[n];
            for (int i = 0; i < n; ++i)
                v[i] = new Pair(in.nextInt(), in.nextInt());
            Arrays.sort(v); // stable
            for (int i = 0; i < n; ++i) out.println(v[i].a + " " + v[i].b);
        }

        class Pair implements Comparable<Pair> {
            int a;
            int b;

            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }


            public int compareTo(Pair other) {
                return other.b - this.b;
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

