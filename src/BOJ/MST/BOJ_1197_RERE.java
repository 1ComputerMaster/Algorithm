package BOJ.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197_RERE {
    static class Data implements Comparable<Data>{
        int where;
        int weight;
        public Data (int where, int weight){
            this.weight = weight;
            this.where = where;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static ArrayList<Data> []graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        graph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Data(to,weight));
            graph[to].add(new Data(from, weight));
        }
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(1,0));
        boolean[] visited = new boolean[V + 1];
        int res = 0;
        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(visited[cur.where]){
                continue;
            }
            visited[cur.where] = true;
            res += cur.weight;
            for (int i = 0; i < graph[cur.where].size(); i++){
                Data next = graph[cur.where].get(i);
                if(!visited[next.where]){
                    pq.add(next);
                }
            }
        }
        System.out.println(res);
    }
}
