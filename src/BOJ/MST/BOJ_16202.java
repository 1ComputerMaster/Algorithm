package BOJ.MST;

import java.util.*;

public class BOJ_16202 {
    private static class Data implements Comparable<Data>{
        int end;
        int weight;
        public Data(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Data o) {
            return this.weight - o.weight;
        }
    }
    static ArrayList<Data>[] graph;
    static Data[] distance;
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<Data>();
        }
        distance = new Data[10000 + 1];
        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = i + 1;
            graph[from].add(new Data(to,weight));
            graph[to].add(new Data(from,weight));
            distance[weight] = new Data(from, to);
        }
        MST();
    }

    private static void MST() {
        PriorityQueue<Data> pq;
        boolean[] visited;
        for (int i = 0; i < K; i++) {
            int ans = 0;
            int min = 1000_000_000;
            pq = new PriorityQueue<>();
            pq.add(new Data(1,0));
            visited = new boolean[N + 1];
            while (!pq.isEmpty()) {
                Data cur = pq.poll();
                if(visited[cur.end]){
                    continue;
                }
                visited[cur.end] = true;
                ans += cur.weight;
                if(min > cur.weight && cur.weight != 0){
                    min = cur.weight;
                }
                for (Data next : graph[cur.end]){
                    if(!visited[next.end] && next.weight > i){
                        pq.add(next);
                    }
                }
            }
            if(check(visited)) {
                System.out.println(ans);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean check(boolean[] visited){
        for (int k = 1; k < visited.length; k++) {
            if(!visited[k]){
                return false;
            }
        }
        return true;
    }
}
