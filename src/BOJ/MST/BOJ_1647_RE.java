package BOJ.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1647_RE {

    static class Data implements Comparable<Data>{
        int where;
        int weight;
        public Data(int where, int weight){
            this.weight = weight;
            this.where = where;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static ArrayList<Data>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<Data>();
        }
        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Data(to, weight));
            graph[to].add(new Data(from, weight));
        }
        MST(N);
    }

    private static void MST(int N) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Data(1,0));
        int ans = 0;
        int cnt = 0;
        int max = 0;
        while (!pq.isEmpty())
        {
            Data cur = pq.poll();
            if(visited[cur.where]){
                continue;
            }
            visited[cur.where] = true;
            ans += cur.weight;
            cnt++;
            max = Math.max(cur.weight,max);
            if(cnt == N){
                System.out.println(ans - max);
            }
            for (Data next : graph[cur.where]){
                if(!visited[next.where]){
                    pq.add(next);
                }
            }
        }
    }
}
