package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20182 {
    static class Data implements Comparable<Data> {
        int node;
        long distance;
        public Data(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Data o) {
            // 최대 비용을 기준으로 정렬
            return Long.compare(this.distance, o.distance);
        }
    }

    static List<Data>[] graph;

    static int N;
    static int start, end;
    static long maxWeight;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(tk.nextToken()); //교차로 갯수
        int M = Integer.parseInt(tk.nextToken()); //골목 갯수
        start = Integer.parseInt(tk.nextToken()); //시작 교차로 번호
        end = Integer.parseInt(tk.nextToken()); //도착 교차로 번호
        maxWeight = Long.parseLong(tk.nextToken()); //가진 돈

        graph = new ArrayList[N + 1];

        for (int i =0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        long maxCost = 0;
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            long weight = Long.parseLong(tk.nextToken());
            maxCost = Math.max(weight, maxCost);
            graph[from].add(new Data(to,weight));
            graph[to].add(new Data(from,weight));
        }

        binarySearch(0,maxCost);
    }

    private static void binarySearch(long left, long right) {
        long ans = -1;
        while (left <= right){
            long mid = (left + right) / 2;
            if(dijkstra(mid)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dijkstra(long weight) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Data(start, 0));
        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(cur.node == end){
                return true;
            }
            if(visited[cur.node]){
               continue;
            }
            visited[cur.node] = true;
            for (Data next : graph[cur.node]){
                if(!visited[next.node]){
                    if(cur.distance + next.distance <= maxWeight && next.distance <= weight){
                        pq.add(new Data(next.node, cur.distance + next.distance));
                    }
                }
            }
        }
        return false;
    }
}
