import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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
        Task1654 solver = new Task1654();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1654 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] v = in.next().toCharArray();
            Stack<Character> Q = new Stack<>();
            for (char x : v) {
                Q.add(x);
                while (Q.size() > 1) {
                    char f = Q.pop();
                    char s = Q.pop();
                    if (f != s) {
                        Q.add(s);
                        Q.add(f);
                        break;
                    }
                }
            }
            Stack<Character> S = new Stack<>();
            while (!Q.isEmpty()) S.add(Q.pop());
            while (!S.isEmpty()) out.print(S.pop());
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

    }
}

