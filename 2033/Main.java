import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
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
        Task2033 solver = new Task2033();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2033 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Map<String, Integer> price = new HashMap<>();
            Map<String, Integer> freq = new HashMap<>();
            for (int i = 0; i < 6; ++i) {
                String n = in.next(), model = in.next();
                int mPrice = in.nextInt();
                if (!freq.containsKey(model)) freq.put(model, 0);
                freq.put(model, freq.get(model) + 1);
                if (!price.containsKey(model)) price.put(model, 1000000000);
                price.put(model, Math.min(price.get(model), mPrice));
            }
            ArrayList<String> cands = new ArrayList<>();
            int maxFreq = 0;
            for (int x : freq.values()) maxFreq = Math.max(maxFreq, x);
            for (String x : freq.keySet())
                if (freq.get(x) == maxFreq) cands.add(x);
            int minPrice = 1000000000;
            String ans = "wololo";
            for (String x : cands) {
                if (price.get(x) < minPrice) {
                    ans = x;
                    minPrice = price.get(x);
                }
            }
            out.println(ans);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

