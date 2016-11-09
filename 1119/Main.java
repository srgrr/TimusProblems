import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
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
        Task1119 solver = new Task1119();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1119 {
        private static int[] dx = {1, -1, 0, 0};
        private static int[] dy = {0, 0, -1, 1};
        private static double diag = 100.0 * Math.sqrt(2.0);

        private boolean isValid(int i, int j, int n, int m) {
            return i >= 0 && i < n && j >= 0 && j < m;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt(), n = in.nextInt();
            ++n;
            ++m;
            int e = in.nextInt();
            boolean[][] has = new boolean[n][m];
            for (int i = 0; i < e; ++i) {
                int l = in.nextInt() - 1, r = in.nextInt() - 1;
                has[r][l] = true;
            }
            boolean[][] vis = new boolean[n][m];
            double[][] dis = new double[n][m];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j) dis[i][j] = 1e12;
            Queue<Pair> Q = new LinkedList<>();
            Q.add(new Pair(0, 0));
            dis[0][0] = 0;
            while (!Q.isEmpty()) {
                Pair v = Q.poll();
                if (vis[v.i][v.j]) continue;
                vis[v.i][v.j] = true;
                for (int k = 0; k < 4; ++k) {
                    int oi = v.i + dx[k];
                    int oj = v.j + dy[k];
                    if (isValid(oi, oj, n, m)) {
                        if (dis[v.i][v.j] + 100.0 < dis[oi][oj]) {
                            dis[oi][oj] = dis[v.i][v.j] + 100.0;
                            Q.add(new Pair(oi, oj));
                        }
                    }
                }
                if (isValid(v.i + 1, v.j + 1, n, m) && has[v.i][v.j]) {
                    //out.println("YEAH!");
                    dis[v.i + 1][v.j + 1] = Math.min(dis[v.i + 1][v.j + 1], dis[v.i][v.j] + diag);
                    Q.add(new Pair(v.i + 1, v.j + 1));
                }
            }
            out.println(Math.round(dis[n - 1][m - 1]));
        }

        private class Pair implements Comparable<Pair> {
            public int i;
            public int j;

            Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }

            public boolean equals(Object other) {
                Pair ot = (Pair) other;
                return compareTo(ot) == 0;
            }


            public int compareTo(Pair other) {
                if (i != other.i) return i - other.i;
                return j - other.j;
            }


            public int hashCode() {
                return 101 * i + 97 * j;
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

