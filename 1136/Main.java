import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.StringTokenizer;
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
        Task1136 solver = new Task1136();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1136 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Stack<Integer> S = new Stack<>();
            for (int i = 0; i < n; ++i) S.add(in.nextInt());
            TreeSet<Node> nodes = new TreeSet<>();
            Node ret = build(S, nodes);
            printTree(ret, out);
        }

        void printTree(Node n, PrintWriter out) {
            if (n == null) return;
            printTree(n.r, out);
            printTree(n.l, out);
            out.println(n.value);
        }

        private Node build(Stack<Integer> S, TreeSet<Node> nodes) {
            if (S.isEmpty()) return null;
            Node ret = new Node(S.pop());
            nodes.add(ret);
            Node f = build(S, nodes);
            if (f != null) {
                if (f.value > ret.value) {
                    ret.r = f;
                } else {
                    Node aux = nodes.ceiling(new Node(f.value + 1));
                    aux.l = f;
                    nodes.remove(aux);
                }
                if (ret.l == null) {
                    ret.l = build(S, nodes);
                    nodes.remove(ret);
                }
            }
            return ret;
        }

        class Node implements Comparable<Node> {
            public int value;
            public Node l;
            public Node r;

            public Node(int value) {
                this.value = value;
            }


            public int compareTo(Node other) {
                return value - other.value;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

