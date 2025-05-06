package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17396 {
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
    static int[] totem;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        totem = new int[N];
        tk = new StringTokenizer(in.readLine()," ");
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();


        for (int i = 0; i < N; i++){
            totem[i] = Integer.parseInt(tk.nextToken());
        }
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            long weight = Long.parseLong(tk.nextToken());
            graph[from].add(new Data(to, weight));
            graph[to].add(new Data(from, weight));
        }
        if(!dijkstra(N)) {
            System.out.println(-1);
        }

    }

    private static boolean dijkstra(int size) {
        Queue<Data> q = new PriorityQueue<>();
        q.add(new Data(0,0));
        boolean [] visited = new boolean[size];

        while (!q.isEmpty()){
            Data cur = q.poll();
            if (visited[cur.start]){
                continue;
            }
            visited[cur.start] = true;
            if(cur.start != size - 1 && totem[cur.start] == 1){
                continue;
            }
            if(cur.start == size - 1){
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
