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
        Task1786 solver = new Task1786();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1786 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String line = in.next();
            int ans = calc(line);
            out.println(ans);
        }

        private int calc(String line) {
            String pattern = "Sandro";
            int ret = 1000000000;
            for (int i = 0; i + pattern.length() - 1 < line.length(); ++i) {
                int editDistance = 0;
                for (int j = 0; j < pattern.length(); ++j)
                    editDistance += getDistance(line.charAt(i + j), pattern.charAt(j));
                ret = Math.min(ret, editDistance);
            }
            return ret;
        }

        private int getDistance(char c, char c1) {
            int ret = 0;
            if (Character.toLowerCase(c) != Character.toLowerCase(c1)) ret += 5;
            if (Character.isLowerCase(c) != Character.isLowerCase(c1)) ret += 5;
            return ret;
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

    }
}

