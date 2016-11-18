import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task1014 solver = new Task1014();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1014 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<Integer> ans = getFactorization(n);
            if (ans.isEmpty()) out.print(-1);
            else for (Integer x : ans) out.print(x);
            out.println();
        }

        private ArrayList<Integer> getFactorization(int n) {
            ArrayList<Integer> ret = new ArrayList<>();
            if (n == 0) {
                ret.add(1);
                ret.add(0);
                return ret;
            } else if (n == 1) {
                ret.add(1);
                return ret;
            } else {
                for (int i = 9; i > 1; --i) {
                    while (n % i == 0) {
                        ret.add(i);
                        n /= i;
                    }
                }
            }
            if (n > 1) ret = new ArrayList<>();
            Collections.sort(ret);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

