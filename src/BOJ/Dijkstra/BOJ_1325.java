package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_1325 {
    static boolean[] visited;
    static int max;
    static int[] ans;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        String[] inputs = new String[2];
        for (int i = 0; i < M; i++) {
            inputs = in.readLine().split(" ");
            graph[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
        }
        max = -1;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }
        for (int i = 0; i < ans.length; i++){
            max = Math.max(max,ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int index) {
        visited[index] = true;
        ans[index]++;
        for (int idx : graph[index]) {
            if (!visited[idx]) {
                dfs(idx);
            }
        }
    }
}
