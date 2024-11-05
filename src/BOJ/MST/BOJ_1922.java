package BOJ.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1922 {
    static class Data implements Comparable<Data>{
        int x;
        int weight;
        public Data(int x, int weight){
            this.x = x;
            this.weight = weight;
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

        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Data(to,weight));
            graph[to].add(new Data(from,weight));
        }
        int res = MST(N + 1);
        System.out.println(res);
    }

    private static int MST(int size) {
        PriorityQueue<Data> pq = new PriorityQueue<Data>();
        pq.add(new Data(1,0));
        boolean[] visited = new boolean[size];
        int res = 0;
        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(visited[cur.x]){
                continue;
            }
            visited[cur.x] = true;
            res += cur.weight;
            for (Data next : graph[cur.x]){
                if(!visited[next.x]){
                    pq.add(next);
                }
            }
        }
        return res;
    }
}
