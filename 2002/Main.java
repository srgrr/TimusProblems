import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
        Task2002 solver = new Task2002();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2002 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            HashMap<String, String> passwords = new HashMap<>();
            Set<String> loggedIn = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                String order = in.next();
                if (order.equals("register")) {
                    String user = in.next(), password = in.next();
                    if (passwords.containsKey(user)) {
                        out.println("fail: user already exists");
                    } else {
                        passwords.put(user, password);
                        out.println("success: new user added");
                    }
                } else if (order.equals("login")) {
                    String user = in.next(), password = in.next();
                    if (!passwords.containsKey(user)) {
                        out.println("fail: no such user");
                    } else if (!passwords.get(user).equals(password)) {
                        out.println("fail: incorrect password");
                    } else if (loggedIn.contains(user)) {
                        out.println("fail: already logged in");
                    } else {
                        loggedIn.add(user);
                        out.println("success: user logged in");
                    }
                } else {
                    String user = in.next();
                    if (!passwords.containsKey(user)) {
                        out.println("fail: no such user");
                    } else if (!loggedIn.contains(user)) {
                        out.println("fail: already logged out");
                    } else {
                        loggedIn.remove(user);
                        out.println("success: user logged out");
                    }
                }
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

