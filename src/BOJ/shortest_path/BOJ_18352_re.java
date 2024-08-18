package BOJ.shortest_path;

import java.util.*;

public class BOJ_18352_re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        List<Integer>[] graph = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1000_000_000);

        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
            graph[to].add(from);
        }
        dijkstra(X, dist, visited, graph);

        boolean checker = false;
        for (int i = 0; i < dist.length; i++){
            if(dist[i] == K){
                System.out.println(i);
                checker = true;
            }
        }
        if(!checker){
            System.out.println(-1);
        }
    }

    private static void dijkstra(int x, int[] dist, boolean[] visited, List<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        while (!q.isEmpty()){
            int curNode = q.poll();
            if(!visited[curNode]){
                visited[curNode] = true;
            }else{
                continue;
            }
            for (int j = 0; j < graph[curNode].size(); j++){
                int nextNode = graph[curNode].get(j);
                if(dist[nextNode] > dist[curNode] + 1){
                    q.add(nextNode);
                    dist[nextNode] = dist[curNode] + 1;
                }
            }
        }
    }
}
