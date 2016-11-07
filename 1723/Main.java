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
        Task1723 solver = new Task1723();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1723 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String x = in.next();
            int[] freqs = new int[26];
            int maxf = 0, maxv = 0;
            for (int i = 0; i < x.length(); ++i) {
                ++freqs[(x.charAt(i) - 'a')];
                if (freqs[(x.charAt(i) - 'a')] > maxf) {
                    maxf = freqs[(x.charAt(i) - 'a')];
                    maxv = (x.charAt(i) - 'a');
                }
            }
            out.println((char) (maxv + 'a'));
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

