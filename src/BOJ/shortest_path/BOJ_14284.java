package BOJ.shortest_path;

import java.util.*;

public class BOJ_14284 {
    static class Data implements Comparable<Data>{
        int start;
        long weight;
        public Data(int start, long weight){
            this.start = start;
            this.weight = weight;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static List<Data>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Data(to, weight));
            graph[to].add(new Data(from, weight));

        }
        int s = sc.nextInt();
        int t = sc.nextInt();
        dijkstra(n, s, t);

    }

    private static boolean dijkstra(int size, int start, int end) {
        Queue<Data> q = new PriorityQueue<>();
        q.add(new Data(start,0));
        boolean [] visited = new boolean[size + 1];

        while (!q.isEmpty()){
            Data cur = q.poll();
            if (visited[cur.start]){
                continue;
            }
            visited[cur.start] = true;
            if(cur.start == end){
                System.out.println(cur.weight);
                return true;
            }
            for (Data next : graph[cur.start]){
                if(!visited[next.start]){
                    q.add(new Data(next.start, next.weight + cur.weight));
                }
            }
        }
        return false;
    }

}
