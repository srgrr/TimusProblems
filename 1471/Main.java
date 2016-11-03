import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        Task1471 solver = new Task1471();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1471 {
        int root;
        ArrayList<Edge>[] g;
        int[][] par;
        int[] dist;
        int[] depth;

        void dfs(int v, int up, int level, int accm) {
            dist[v] = accm;
            depth[v] = level;
            par[v][0] = v == root ? v : up;
            for (Edge e : g[v]) {
                if (e.v != up) {
                    dfs(e.v, v, level + 1, accm + e.w);
                }
            }
        }

        int lca(int u, int v) {
            if (depth[u] > depth[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            while (depth[v] != depth[u]) {
                for (int i = 16; i >= 0; --i) {
                    if (depth[par[v][i]] >= depth[u]) {
                        v = par[v][i];
                        break;
                    }
                }
            }
            while (true) {
                if (u == v) return u;
                if (par[u][0] == v) return v;
                if (par[v][0] == u) return u;
                if (par[u][0] == par[v][0]) return par[u][0];
                for (int i = 16; i >= 0; --i) {
                    if (par[u][i] != par[v][i]) {
                        u = par[u][i];
                        v = par[v][i];
                        break;
                    }
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            g = new ArrayList[n];
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
            par = new int[n][17];
            dist = new int[n];
            depth = new int[n];
            root = Math.abs((int) (new Random()).nextInt()) % n;
            for (int i = 1; i < n; ++i) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                g[u].add(new Edge(v, w));
                g[v].add(new Edge(u, w));
            }
            dfs(root, -1, 0, 0);
            for (int i = 1; i < 17; ++i) {
                for (int j = 0; j < n; ++j) {
                    par[j][i] = par[par[j][i - 1]][i - 1];
                }
            }
            int m = in.nextInt();
            while (m > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                int ans = dist[u] + dist[v] - 2 * dist[lca(u, v)];
                out.println(ans);
                --m;
            }
        }

        class Edge {
            int v;
            int w;

            public Edge(int v, int w) {
                this.v = v;
                this.w = w;
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
