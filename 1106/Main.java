import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
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
        Task1106 solver = new Task1106();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1106 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = in.nextInt() - 1;
                while (x >= 0) {
                    g[i].add(x);
                    g[x].add(i);
                    x = in.nextInt() - 1;
                }
            }
            boolean[] teams = calc(g);
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (!isValid(teams, g, i)) {
                    out.println(0);
                    return;
                }
                if (teams[i]) ans.add(i + 1);
            }
            out.println(ans.size());
            for (int i = 0; i < ans.size(); ++i) {
                if (i > 0) out.print(" ");
                out.print(ans.get(i));
            }
            out.println();
        }

        private boolean isValid(boolean[] teams, ArrayList<Integer>[] g, int i) {
            for (int adj : g[i]) if (teams[i] != teams[adj]) return true;
            return false;
        }

        private boolean[] calc(ArrayList<Integer>[] g) {
            int n = g.length;
            boolean[] ret = new boolean[n];
            boolean[] vis = new boolean[n];
            Queue<Integer> Q = new LinkedList<>();
            for (int root = 0; root < n; ++root) {
                Q.add(root);
                while (!Q.isEmpty()) {
                    int v = Q.poll();
                    if (!vis[v]) {
                        vis[v] = true;
                        for (int adj : g[v]) {
                            if (!vis[adj]) {
                                Q.add(adj);
                                ret[adj] = !ret[v];
                            }
                        }
                    }
                }
            }
            return ret;
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

