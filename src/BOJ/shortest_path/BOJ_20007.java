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

    private static long[] dijkstra(int N, int start) {
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0));

        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            if (cur.distance > dist[cur.node]) continue;

            for (Data next : graph[cur.node]) {
                long newDist = cur.distance + next.distance;
                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    pq.add(new Data(next.node, newDist));
                }
            }
        }
        return dist;
    }

    private static boolean canVisitAll(long[] dist, long maxDistance) {
        for (long d : dist) {
            if (d == Long.MAX_VALUE || d * 2 > maxDistance) return false; // 방문할 수 없는 집이 존재
        }
        return true;
    }

    private static int minDaysToVisit(long[] dist, long maxDistance) {
        Arrays.sort(dist); // 가까운 거리부터 방문
        int days = 0;
        long dailyDistance = 0;

        for (long d : dist) {
            long roundTrip = 2 * d; // 왕복 거리
            if (dailyDistance + roundTrip > maxDistance) {
                days++; // 새로운 하루 시작
                dailyDistance = 0;
            }
            dailyDistance += roundTrip;
        }

        if (dailyDistance > 0) days++; // 마지막 남은 거리 처리
        return days;
    }
}
