package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken()); //K번 거쳐서 도착 할 수 있는 곳 출력
        int X = Integer.parseInt(tk.nextToken()); //X에서 출발함

        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            graph[from].add(to);
//            graph[to].add(from);

        }

        dijkstra(X,N);
        boolean non = false;
        for (int i = 0; i <= N; i++){
            if(dist[i] == K){
                non = true;
                System.out.println(i);
            }
        }
        if(!non){
            System.out.println(-1);
        }

    }
    static int dist[];
    private static void dijkstra(int start, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[N + 1];
        dist = new int[N + 1];
        while (!q.isEmpty()){
            int to = q.poll();
            if(visited[to]){
                continue;
            }
            visited[to] = true;
            for (int t : graph[to]){
                if(!visited[t] && dist[t] == 0) {
                    q.offer(t);
                    dist[t] = dist[to] + 1;
                }
            }
        }
    }
}
