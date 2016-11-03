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
        Task2023 solver = new Task2023();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2023 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String[] box1 = {"alice", "ariel", "aurora",
                    "phil", "peter", "olaf",
                    "phoebus", "ralph", "robin"};
            String[] box2 = {"bambi", "belle", "bolt",
                    "mulan", "mowgli", "mickey",
                    "silver", "simba", "stitch"};
            String[] box3 = {"dumbo", "genie", "jiminy",
                    "kuzko", "kida", "kenai",
                    "tarzan", "tiana", "winnie"};
            HashMap<String, Integer> S = new HashMap<>();
            for (String x : box1) S.put(x, 0);
            for (String x : box2) S.put(x, 1);
            for (String x : box3) S.put(x, 2);
            int n = in.nextInt();
            int ans = 0;
            int current = 0;
            for (int testCase = 0; testCase < n; ++testCase) {
                String x = in.next().toLowerCase();
                ans += Math.abs(current - S.get(x));
                current = S.get(x);
            }
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

