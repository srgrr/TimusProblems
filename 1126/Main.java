import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task1126 solver = new Task1126();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1126 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            Queue<Integer> byInput = new LinkedList<>();
            MultiSet<Integer> Q = new MultiSet<>(true);
            for (int i = 0; i < m; ++i) {
                int x = in.nextInt();
                byInput.add(x);
                Q.add(x);
            }

            out.println(Q.first());
            int inp = in.nextInt();
            while (inp != -1) {
                Q.remove(byInput.poll());
                byInput.add(inp);
                Q.add(inp);
                out.println(Q.first());
                inp = in.nextInt();
            }
        }

    }

    static class MultiSet<K> {
        private volatile int size;
        private volatile Map<K, Integer> M;
        private volatile TreeSet<K> S;

        public MultiSet() {
            size = 0;
            M = new TreeMap<>();
            S = new TreeSet<>();
        }

        public MultiSet(boolean reverse) {
            size = 0;
            M = new TreeMap<>();
            if (reverse) {
                M = new TreeMap<>(Collections.reverseOrder());
                S = new TreeSet<>(Collections.reverseOrder());
            } else {
                M = new TreeMap<>();
                S = new TreeSet<>();
            }
        }

        public boolean contains(K x) {
            return M.containsKey(x);
        }

        public int get(K x) {
            if (contains(x)) return M.get(x);
            return 0;
        }

        private void put(K x, Integer y) {
            size -= get(x);
            M.put(x, y);
            S.add(x);
            size += y;
        }

        public void addAmount(K x, int amount) {
            if (amount < 0) throw new NullPointerException();
            if (amount == 0) return;
            put(x, get(x) + amount);
        }

        public void removeAmount(K x, int amount) {
            int oldAmount = get(x);
            if (amount > oldAmount) throw new NullPointerException();
            if (amount == oldAmount) {
                M.remove(x);
                S.remove(x);
                size -= amount;
            } else {
                put(x, oldAmount - amount);
            }
        }

        public void add(K x) {
            addAmount(x, 1);
        }

        public void remove(K x) {
            removeAmount(x, 1);
        }

        public Set<K> keySet() {
            return M.keySet();
        }

        public K first() {
            for (K x : keySet()) return x;
            throw new NullPointerException();
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

