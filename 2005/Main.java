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
        Task2005 solver = new Task2005();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2005 {
        int[][] g = new int[5][5];
        int[] bestSolution = new int[5];
        int[] tmpSolution = new int[5];
        int bestCost = 999999999;
        boolean[] vis = new boolean[5];

        void backtrack(int ix, int cost) {
            if (ix == 5) {
                if (tmpSolution[4] == 4 && cost < bestCost) {
                    bestSolution = tmpSolution.clone();
                    bestCost = cost;
                }
            } else {
                for (int i = 0; i < 5; ++i) {
                    if (!vis[i] && !(ix == 3 && i == 2)) {
                        vis[i] = true;
                        tmpSolution[ix] = i;
                        backtrack(ix + 1, cost + g[tmpSolution[ix - 1]][tmpSolution[ix]]);
                        vis[i] = false;
                    }
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 0; i < 5; ++i)
                for (int j = 0; j < 5; ++j)
                    g[i][j] = in.nextInt();
            tmpSolution[0] = 0;
            vis[0] = true;
            backtrack(1, 0);
            out.println(bestCost);
            for (int i = 0; i < 5; ++i) {
                if (i > 0) out.print(" ");
                out.print((bestSolution[i] + 1));
            }
            out.println();
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

