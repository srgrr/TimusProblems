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
        Task1410 solver = new Task1410();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1410 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int[] v = new int[20009];
            int n = 0;

            while (true) {
                try {
                    String[] e = in.next().split("[^a-zA-Z]+");
                    for (int i = 0; i < e.length; ++i) {
                        v[n++] = e[i].length();
                    }
                } catch (Exception e) {
                    break;
                }
            }

            if (n == 0) {
                out.println(0);
                return;
            }

            if (n == 1) {
                out.println(v[0]);
                return;
            }
            int[] dp = new int[n];
            dp[n - 1] = v[n - 1];
            dp[n - 2] = v[n - 2];
            SegmentTree st = new SegmentTree(n, 1 << 20);
            st.insertElement(n - 1, dp[n - 1]);
            st.insertElement(n - 2, dp[n - 2]);
            int ans = Math.max(dp[n - 1], dp[n - 2]);
            for (int i = n - 3; i >= 0; --i) {
                dp[i] = Math.max(dp[i + 1], v[i] + st.getIntervalValue(i + 2, n - 1));
                st.insertElement(i, dp[i]);
                ans = Math.max(ans, dp[i]);
            }
            out.println(ans);
        }

        public class SegmentTree {
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
                return Math.max(_getIntervalValue(ql, qr, l, h, 2 * id), _getIntervalValue(ql, qr, h + 1, r, 2 * id + 1));
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
                    tree[id] = Math.max(tree[2 * id], tree[2 * id + 1]);
                    // OPERATION TYPE !!!!
                }
            }

            public void insertElement(int index, int val) {
                _insertElement(index, val, 0, n - 1, 1);
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

    }
}
