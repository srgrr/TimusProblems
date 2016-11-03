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
        Task1987 solver = new Task1987();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1987 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            TreeSet<Interval> S = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                S.add(new Interval(in.nextInt(), in.nextInt(), i));
            }
            int q = in.nextInt();
            TreeSet<Interval> I = new TreeSet<>();
            for (int i = 0; i < q; ++i) {
                int x = in.nextInt();
                while (!S.isEmpty() && S.first().l <= x) {
                    Interval f = S.pollFirst();
                    I.add(new Interval(f.r, 0, f.id));
                }
                while (!I.isEmpty() && I.first().l < x) {
                    I.pollFirst();
                }
                if (I.isEmpty()) out.println("-1");
                else out.println((I.first().id + 1));
            }
        }

        class Interval implements Comparable<Interval> {
            int l;
            int r;
            int id;

            public Interval(int l, int r, int id) {
                this.l = l;
                this.r = r;
                this.id = id;
            }


            public int compareTo(Interval other) {
                if (this.l != other.l)
                    return this.l - other.l;
                return this.id - other.id;
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
