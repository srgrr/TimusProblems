import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
        Task1601 solver = new Task1601();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1601 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Set<Character> delimiters = new HashSet<>();
            delimiters.add('!');
            delimiters.add('?');
            delimiters.add('.');
            String line;
            boolean first = true;
            while (true) {
                try {
                    line = in.nextLine();
                } catch (Exception e) {
                    return;
                }
                if (line == null) return;
                for (int i = 0; i < line.length(); ++i) {
                    char cur = line.charAt(i);
                    if (delimiters.contains(cur)) {
                        out.print(cur);
                        first = true;
                    } else if (Character.isAlphabetic(cur)) {
                        if (!first) out.print(Character.toLowerCase(cur));
                        else out.print(Character.toUpperCase(cur));
                        first = false;
                    } else out.print(cur);
                }
                out.println();
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

