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
        Task1792 solver = new Task1792();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1792 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int[] v = new int[7];
            for (int i = 0; i < 7; ++i) v[i] = in.nextInt();
            if (isHamming(v)) {
                printArray(v, out);
                return;
            }
            for (int i = 0; i < 7; ++i) {
                v[i] ^= 1;
                if (isHamming(v)) {
                    printArray(v, out);
                    return;
                }
                v[i] ^= 1;
            }
        }

        private boolean isHamming(int[] v) {
            return ((v[1] ^ v[2] ^ v[3]) == v[4]) && ((v[0] ^ v[2] ^ v[3]) == v[5]) && ((v[0] ^ v[1] ^ v[3]) == v[6]);
        }

        void printArray(int[] v, PrintWriter out) {
            for (int i = 0; i < v.length; ++i) {
                if (i > 0) out.print(" ");
                out.print(v[i]);
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

