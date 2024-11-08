package BOJ.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_21924_RE {

    static class Data implements Comparable<Data>{
        int where;
        long weight;
        public Data(int where, long weight){
            this.weight = weight;
            this.where = where;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.weight, o.weight);
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
        long sum = 0;
        for (int i = 0; i < M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            long weight = sc.nextLong();
            sum += weight;
            graph[from].add(new Data(to, weight));
            graph[to].add(new Data(from, weight));
        }
        long res = MST(N);
        if(res == 0){
            System.out.println(-1);
        }else {
            System.out.println(sum - res);
        }
    }

    private static long MST(int N) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Data(1,0));
        long ans = 0;
        visited[0] = true;
        while (!pq.isEmpty())
        {
            Data cur = pq.poll();
            if(visited[cur.where]){
                continue;
            }
            visited[cur.where] = true;
            ans += cur.weight;
            if(canIgo(visited))
            {
                return (ans);
            }
            for (Data next : graph[cur.where]){
                if(!visited[next.where]){
                    pq.add(next);
                }
            }
        }
        return 0;
    }

    private static boolean canIgo(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
