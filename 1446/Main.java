import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
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
        Task1446 solver = new Task1446();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1446 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashMap<String, Integer> H = new HashMap<>();
            String[] houses = new String[]{"Slytherin", "Hufflepuff", "Gryffindor", "Ravenclaw"};
            for (int i = 0; i < 4; ++i) H.put(houses[i], i);
            ArrayList<String>[] S = new ArrayList[4];
            for (int i = 0; i < 4; ++i) S[i] = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                String name = in.nextLine(), h = in.nextLine();
                S[H.get(h)].add(name);
            }
            for (int i = 0; i < 4; ++i) {
                out.println(houses[i] + ":");
                for (Object x : S[i]) out.println((String) x);
                out.println();
            }
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

