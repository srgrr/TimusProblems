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
        Task1494 solver = new Task1494();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1494 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            SegmentTree st = new SegmentTree(n, 1 << 21);
            int prev = -1;
            for (int i = 0; i < n; ++i) {
                int x = in.nextInt();
                if (x < prev && st.getIntervalValue(x, prev) != prev - x + 1) {
                    out.println("Cheater");
                    return;
                }
                --x;
                prev = x;
                st.insertElement(x, 1);
            }
            out.println("Not a proof");
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

    static class SegmentTree {
        public int[] tree;
        public int n;
        public int capacity;

        public SegmentTree(int numel, int tcapacity) {
            n = numel;
            capacity = tcapacity;
            tree = new int[capacity];
        }

        public int _getIntervalValue(int ql, int qr, int l, int r, int id) {
            if (ql <= l && qr >= r) return tree[id];
            if (ql > r || qr < l) return 0;
            int h = (l + r) / 2;
            return _getIntervalValue(ql, qr, l, h, 2 * id) + _getIntervalValue(ql, qr, h + 1, r, 2 * id + 1);
        }

        public int getIntervalValue(int l, int r) {
            return _getIntervalValue(l, r, 0, n - 1, 1);
        }

        public void _insertElement(int pos, int val, int l, int r, int id) {
            if (pos < l || pos > r) return;
            if (pos == l && l == r) {
                tree[id] = val;
            } else {
                int h = (l + r) / 2;
                _insertElement(pos, val, l, h, 2 * id);
                _insertElement(pos, val, h + 1, r, 2 * id + 1);
                // OPERATION TYPE !!!!
                tree[id] = tree[2 * id] + tree[2 * id + 1];
                // OPERATION TYPE !!!!
            }
        }

        public void insertElement(int index, int val) {
            _insertElement(index, val, 0, n - 1, 1);
        }

    }
}
