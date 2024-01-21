package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1967 {
    static class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static boolean visited[];
    static List<Node>[] listNode;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        visited = new boolean[N + 1];
        listNode = new ArrayList[N + 1];
        for (int i = 0; i < listNode.length; i++) {
            listNode[i] = new ArrayList<Node>();
        }
        ans = 0;
        for (int i = 0; i < N - 1; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());
            listNode[a].add(new Node(b, d));
            listNode[b].add(new Node(a, d));

        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i,0);
        }
        System.out.println(ans);
    }
    private static void dfs(int idx, int cnt) {
        visited[idx] = true;
        ans = Math.max(cnt, ans);
        for (Node node : listNode[idx]) {
            if (!visited[node.node]) {
                visited[node.node] = true;
                dfs(node.node, cnt + node.weight);
            }
        }
    }
}