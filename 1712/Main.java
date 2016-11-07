import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        Task1712 solver = new Task1712();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1712 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[][][] P = new char[4][4][];
            for (int i = 0; i < 4; ++i) P[0][i] = in.next().toCharArray();
            for (int i = 1; i < 4; ++i) P[i] = rot90(P[i - 1]);
            char[][] T = new char[4][];
            for (int i = 0; i < 4; ++i) T[i] = in.next().toCharArray();
            ArrayList<Character> ans = new ArrayList<>();
            for (int i = 4; i > 0; --i) {
                for (int j = 0; j < 4; ++j) {
                    for (int k = 0; k < 4; ++k) {
                        if (P[i % 4][j][k] == 'X') ans.add(T[j][k]);
                    }
                }
            }
            for (char x : ans) out.print(x);
            out.println();
        }

        private char[][] rot90(char[][] t) {
            char[][] ret = new char[t.length][t[0].length];
            for (int i = 0; i < t.length; ++i) {
                for (int j = 0; j < t[0].length; ++j) {
                    ret[i][j] = t[j][t.length - i - 1];
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

    }
}

