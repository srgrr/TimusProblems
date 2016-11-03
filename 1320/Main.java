import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        Task1320 solver = new Task1320();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1320 {
        ArrayList<Integer>[] g = new ArrayList[1000];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 0; i < 1000; ++i) g[i] = new ArrayList<>();
            while (true) {
                try {
                    int u = in.nextInt() - 1;
                    int v = in.nextInt() - 1;
                    g[u].add(v);
                    g[v].add(u);
                } catch (Exception e) {
                    break;
                }
            }

            boolean[] vis = new boolean[1000];

            for (int i = 0; i < 1000; ++i) {
                if (!vis[i]) {
                    int cnt = 0;
                    Stack<Integer> S = new Stack<>();
                    S.add(i);
                    while (!S.isEmpty()) {
                        int v = S.pop();
                        if (!vis[v]) {
                            cnt += g[v].size();
                            vis[v] = true;
                            for (int adj : g[v]) {
                                S.add(adj);
                            }
                        }
                    }
                    if (cnt % 4 != 0) {
                        out.println(0);
                        return;
                    }
                }
            }

            out.println(1);

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
