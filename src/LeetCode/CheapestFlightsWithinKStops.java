package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}, {1,3,600}}, 0, 3, 1));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]dist = new int[n];
        ArrayList<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<int[]>();
        }

        for(int[] go : flights){
            int from = go[0];
            int to = go[1];
            int weight = go[2];
            graph[from].add(new int[]{to, weight});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty() && k >= 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int node = cur[0];
                int price = cur[1];
                for(int[] next : graph[node]){
                    int nextNode = next[0];
                    int nextPrice = next[1];
                    int newPrice = price + nextPrice;
                    if (newPrice < dist[nextNode]) {
                        dist[nextNode] = newPrice;
                        queue.offer(new int[]{nextNode, newPrice});
                    }
                }
            }
            k--;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
