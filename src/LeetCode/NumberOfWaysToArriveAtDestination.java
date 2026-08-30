package LeetCode;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        NumberOfWaysToArriveAtDestination obj = new NumberOfWaysToArriveAtDestination();
        System.out.println(obj.countPaths(n, roads));
    }
    final long MOD = (long) 1e9 + 7;
    public int countPaths(int n, int[][] roads) {

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                Comparator.comparingLong(a -> a[1])
        );
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int curNode = (int) curr[0];
            long curTime = curr[1];

            if (dist[curNode] < curTime) continue;

            for (int[] next : graph[curNode]){
                int nextNode = next[0];
                int nextTime = next[1];

                if (dist[nextNode] > curTime + nextTime){
                    dist[nextNode] = curTime + nextTime;
                    ways[nextNode] = ways[curNode];

                    pq.offer(new long[]{nextNode, nextTime + curTime});
                }else if (dist[nextNode] == curTime + nextTime){
                    ways[nextNode] = (ways[nextNode] + ways[curNode]) % MOD;
                }
            }

        }
        return (int) ways[n - 1];
    }
}
