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
        Task1197 solver = new Task1197();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1197 {
        boolean isValid(int i, int j) {
            return i >= 0 && i < 8 && j >= 0 && j < 8;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int[] dx = new int[]{0, 0, 1, -1};
            int[] dy = new int[]{1, -1, 0, 0};
            for (int testCase = 0; testCase < T; ++testCase) {
                String iniPos = in.next();
                int i = (iniPos.charAt(0) - 'a');
                int j = (iniPos.charAt(1) - '1');
                int ans = 0;
                for (int k = 0; k < 4; ++k) {
                    if (isValid(i + 2 * dx[k] + dy[k], j + 2 * dy[k] - dx[k])) ++ans;
                    if (isValid(i + 2 * dx[k] - dy[k], j + 2 * dy[k] + dx[k])) ++ans;
                }
                out.println(ans);
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

