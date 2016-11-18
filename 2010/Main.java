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
        Task2010 solver = new Task2010();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2010 {
        static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), r = in.nextInt(), c = in.nextInt();
            out.printf("King: %d\n", solveKing(n, r, c));
            out.printf("Knight: %d\n", solveKnight(n, r, c));
            out.printf("Bishop: %d\n", solveBishop(n, r, c));
            out.printf("Rook: %d\n", solveRook(n, r, c));
            out.printf("Queen: %d\n", solveQueen(n, r, c));
        }

        private boolean isValid(int n, int r, int c) {
            return r >= 1 && r <= n && c >= 1 && c <= n;
        }

        private int solveQueen(int n, int r, int c) {
            return solveBishop(n, r, c) + solveRook(n, r, c);
        }

        private int solveRook(int n, int r, int c) {
            int ans = 0;
            for (int i = 0; i < 8; ++i) {
                if (dx[i] * dy[i] == 0) {
                    ans += findLongestDiagonal(n, r, c, dx[i], dy[i]);
                }
            }
            return ans;
        }

        private int solveBishop(int n, int r, int c) {
            int ans = 0;
            for (int i = 0; i < 8; ++i) {
                if (dx[i] * dy[i] != 0) {
                    ans += findLongestDiagonal(n, r, c, dx[i], dy[i]);
                }
            }
            return ans;
        }

        private int solveKnight(int n, int r, int c) {
            int ans = 0;
            for (int i = 0; i < 8; ++i) {
                if (dx[i] * dy[i] == 0) {
                    if (isValid(n, r + 2 * dx[i] + dy[i], c + 2 * dy[i] - dx[i])) ++ans;
                    if (isValid(n, r + 2 * dx[i] - dy[i], c + 2 * dy[i] + dx[i])) ++ans;
                }
            }
            return ans;
        }

        private int solveKing(int n, int r, int c) {
            int ans = 0;
            for (int i = 0; i < 8; ++i)
                if (isValid(n, r + dx[i], c + dy[i])) ++ans;
            return ans;
        }

        private int findLongestDiagonal(int n, int i, int j, int vi, int vj) {
            int l = 0, r = 100000009;
            int ans = 0;
            while (l <= r) {
                int h = (l + r) / 2;
                if (!isValid(n, i + h * vi, j + h * vj)) {
                    r = h - 1;
                } else {
                    ans = h;
                    l = h + 1;
                }
            }
            return ans;
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

