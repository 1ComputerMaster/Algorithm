package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16562 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken()); // 전체 학생 수
        int M = Integer.parseInt(tk.nextToken()); // 친구 관계 수
        int K = Integer.parseInt(tk.nextToken()); // 가지고 있는 돈

        int[] parent = new int[N + 1];
        int[] cost = new int[N + 1];

        tk = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            cost[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int v = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());
            union(parent, cost, v, w);
        }

        // 그룹별 최소 비용 합산
        int totalCost = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int root = find(parent, i);
            if (!visited[root]) {
                totalCost += cost[root];
                visited[root] = true;
            }
        }

        if (totalCost <= K) {
            System.out.println(totalCost);
        } else {
            System.out.println("Oh no");
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int[] cost, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            // 작은 비용의 학생을 그룹의 대표로 만듬
            if (cost[rootA] < cost[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }
    }
}
