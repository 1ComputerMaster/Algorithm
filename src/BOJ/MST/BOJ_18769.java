package BOJ.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_18769 {
    static class Data implements Comparable<Data>{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.y, o.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int R = sc.nextInt();
            int C = sc.nextInt();
            // 인접 리스트 생성
            List<Data>[] graph = new ArrayList[R * C];
            for (int i = 0; i < R * C; i++) {
                graph[i] = new ArrayList<>();
            }

            // 가로 간선 추가
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C - 1; j++) {
                    int weight = sc.nextInt();
                    int from = i * C + j;
                    int to = i * C + j + 1;
                    graph[from].add(new Data(to, weight));
                    graph[to].add(new Data(from, weight));
                }
            }

            // 세로 간선 추가
            for (int i = 0; i < R - 1; i++) {
                for (int j = 0; j < C; j++) {
                    int weight = sc.nextInt();
                    int from = i * C + j;
                    int to = (i + 1) * C + j;
                    graph[from].add(new Data(to, weight));
                    graph[to].add(new Data(from, weight));
                }
            }
            System.out.println(MST(graph, R * C));
        }
    }
    private static int MST(List<Data>[] graph, int size) {
        PriorityQueue<Data> pq = new PriorityQueue<Data>();
        pq.add(new Data(0,0));
        boolean[] visited = new boolean[size];
        int res = 0;
        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(visited[cur.x]){
                continue;
            }
            visited[cur.x] = true;
            res += cur.y;
            for (Data next : graph[cur.x]){
                if(!visited[next.x]){
                    pq.add(next);
                }
            }
        }
        return res;
    }
}
