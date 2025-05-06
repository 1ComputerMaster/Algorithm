package BOJ.shortest_path;

import java.util.*;

/**
 * 거리를 우선 먼저 다 구한 후 일반적인 구현 문제 처럼 푼다는게 핵심 포인트입니다.
 */
public class BOJ_20007 {
    static class Data implements Comparable<Data> {
        int node;
        long distance;

        public Data(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    static List<Data>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집의 개수
        int M = sc.nextInt(); // 도로의 개수
        long X = sc.nextLong(); // 하루 최대 이동 가능 거리
        int Y = sc.nextInt(); // 시작 위치

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long weight = sc.nextLong();
            graph[from].add(new Data(to, weight));
            graph[to].add(new Data(from, weight));
        }

        long[] dist = dijkstra(N, Y);

        if (!canVisitAll(dist, X)) {
            System.out.println(-1);
        } else {
            System.out.println(minDaysToVisit(dist, X));
        }
    }

    private static boolean canVisitAll(long[] dist, long x) {
        for (int i = 0; i < dist.length; i++){
            if(dist[i] * 2 > x || dist[i] == Long.MAX_VALUE){
                return false;
            }
        }
        return true;
    }

    private static int minDaysToVisit(long[] dist, long x) {
        Arrays.sort(dist);
        int day = 0;
        long dayDistance = 0;
        int i = 0;
        for (long d : dist){
            if(dayDistance + d * 2 > x){
                day++;
               dayDistance = 0;
            }
            dayDistance += d * 2;
        }
        if (dayDistance > 0) day++;
        return day;
    }

    private static long[] dijkstra(int n, int start) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0));
        boolean[] visited = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()){
            Data cur = pq.poll();
            if(visited[cur.node]){
                continue;
            }
            visited[cur.node] = true;

            for (Data next : graph[cur.node]){
                if(!visited[next.node] && dist[next.node] > cur.distance + next.distance) {
                    pq.add(new Data(next.node, cur.distance + next.distance));
                    dist[next.node] = cur.distance + next.distance;
                }
            }
        }
        return dist;
    }
}
