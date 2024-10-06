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
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1000_000_000);

        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
        }
        dijkstra(X, dist, graph);
        boolean check = false;
        for (int i = 0; i < dist.length; i++){
            if(dist[i] == K){
                System.out.println(i);
                check = true;
            }
        }
        if(!check){
            System.out.println(-1);
        }
    }
    private static void dijkstra(int x, int[] dist, List<Integer>[] graph){
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(x);
        dist[x] = 0;
        while (!pq.isEmpty()){
            int cur = pq.poll();
            for (int i = 0; i < graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(dist[next] > dist[cur] + 1){
                    pq.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
}
