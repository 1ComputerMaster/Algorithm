package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18116 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());

        int[] parent = new int[1000001];
        int[] size = new int[1000001];

        // 초기화
        for (int i = 1; i <= 1000000; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            String command = tk.nextToken();
            if (command.equals("I")) {
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());
                union(parent, size, a, b);
            } else if (command.equals("Q")) {
                int a = Integer.parseInt(tk.nextToken());
                int root = find(parent, a);
                System.out.println(size[root]);
            }
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int[] size, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
}
