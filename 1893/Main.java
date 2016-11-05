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
        Task1893 solver = new Task1893();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1893 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String line = in.nextLine();
            int row = Integer.parseInt(line.substring(0, line.length() - 1));
            char seat = line.charAt(line.length() - 1);

            if (row < 3) {
                if (seat == 'A' || seat == 'D') out.println("window");
                else out.println("aisle");
            } else if (row < 21) {
                if (seat == 'A' || seat == 'F') out.println("window");
                else out.println("aisle");
            } else {
                if (seat > 'I') seat = (char) (seat - 1);
                if (seat == 'A' || seat == 'J') out.println("window");
                else if (seat == 'C' || seat == 'D' || seat == 'G' || seat == 'H') out.println("aisle");
                else out.println("neither");
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

