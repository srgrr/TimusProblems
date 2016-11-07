import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
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
        Task1837 solver = new Task1837();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1837 {
        static final int inf = 1000009;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Set<String> names = new TreeSet<>();
            HashMap<String, ArrayList<String>> g = new HashMap<>();
            for (int edg = 0; edg < n; ++edg) {
                String[] v = new String[3];
                for (int i = 0; i < 3; ++i) {
                    v[i] = in.next();
                    names.add(v[i]);
                    if (!g.containsKey(v[i])) g.put(v[i], new ArrayList<>());
                }
                for (int i = 0; i < 3; ++i) {
                    for (int j = i + 1; j < 3; ++j) {
                        g.get(v[i]).add(v[j]);
                        g.get(v[j]).add(v[i]);
                    }
                }
            }
            for (String x : names) {
                out.print(x + " ");
                int ans = calcDist(g, x);
                if (ans >= inf) out.println("undefined");
                else out.println(ans);
            }
        }

        private int calcDist(HashMap<String, ArrayList<String>> g, String x) {
            Set<String> vis = new HashSet<>();
            Queue<String> Q = new LinkedList<>();
            HashMap<String, Integer> dist = new HashMap<>();
            for (String node : g.keySet()) dist.put(node, inf);
            dist.put(x, 0);
            Q.add(x);
            while (!Q.isEmpty()) {
                String v = Q.poll();
                if (v.equals("Isenbaev")) break;
                if (!vis.contains(v)) {
                    vis.add(v);
                    for (String adj : g.get(v)) {
                        int curDist = dist.containsKey(adj) ? dist.get(adj) : inf;
                        if (curDist > dist.get(v) + 1) {
                            dist.put(adj, dist.get(v) + 1);
                            Q.add(adj);
                        }
                    }
                }
            }
            return dist.containsKey("Isenbaev") ? dist.get("Isenbaev") : inf;
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

