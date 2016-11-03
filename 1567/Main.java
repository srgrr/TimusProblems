import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
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
        Task1567 solver = new Task1567();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1567 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] cost1 = new char[]{'a', 'd', 'g', 'j', 'm', 'p', 's', 'v', 'y', '.', ' '};
            char[] cost2 = new char[]{'b', 'e', 'h', 'k', 'n', 'q', 't', 'w', 'z', ','};
            char[] cost3 = new char[]{'c', 'f', 'i', 'l', 'o', 'r', 'u', 'x', '!'};
            HashMap<Character, Integer> costs = new HashMap<>();
            for (char x : cost1) costs.put(x, 1);
            for (char x : cost2) costs.put(x, 2);
            for (char x : cost3) costs.put(x, 3);
            char[] inp = in.nextLine().toCharArray();
            int ans = 0;
            for (char x : inp) ans += costs.get(x);
            out.println(ans);
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

