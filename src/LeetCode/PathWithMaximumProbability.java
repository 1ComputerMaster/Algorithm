package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
        System.out.println(pathWithMaximumProbability.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].add(new double[]{v, prob});
            graph[v].add(new double[]{u, prob});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, 1.0});
        double[] dist = new double[n];
        dist[start_node] = 1.0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double weight = curr[1];
            if (node == end_node) {
                return weight;
            }
            for (double[] neighbor : graph[node]){
                int nextNode = (int) neighbor[0];
                double nW = neighbor[1];
                if(dist[node] * nW  > dist[nextNode]){
                    dist[nextNode] = dist[node] * nW;
                    pq.offer(new double[]{nextNode, dist[nextNode]});
                }
            }
        }
        return 0.0;
    }
}
