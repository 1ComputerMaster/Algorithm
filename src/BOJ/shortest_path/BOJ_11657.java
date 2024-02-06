package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11657 {
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        List<Edge> edges = new ArrayList<>();

        int[] minDist = new int[N + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");

            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            int dist = Integer.parseInt(tk.nextToken());
            edges.add(new Edge(from, to, dist));
        }

        if(bellmanFord(edges, minDist, 1)){
            // 1번 노드를 제외한 나머지 노드로 가는 최단 거리를 출력합니다.
            for (int i = 2; i <= N; i++) {
                // 도달할 수 없는 경우 -1을 출력합니다.
                if(minDist[i] == Integer.MAX_VALUE){
                    System.out.println("-1");
                }
                // 도달할 수 있는 경우 거리를 출력합니다.
                else {
                    System.out.println(minDist[i]);
                }
            }
        }
        // 음수 사이클이 존재하는 경우 -1을 출력합니다.
        else {
            System.out.println("-1");
        }

    }

    private static boolean bellmanFord(List<Edge> edges, int[] minDist, int start) {
        minDist[start] = 0;
        // (노드의 개수 - 1)번 만큼 반복합니다.
        for (int i = 0; i < N - 1; i++) {
            // 모든 간선을 확인합니다.
            for (Edge edge : edges) {
                if (minDist[edge.from] != Integer.MAX_VALUE && minDist[edge.to] > minDist[edge.from] + edge.dist) {
                    minDist[edge.to] = minDist[edge.from] + edge.dist;
                }
            }
        }
        for (Edge edge : edges) {
            // 최단 거리 테이블이 갱신되는 경우가 있으면 음수 사이클이 존재합니다.
            if (minDist[edge.from] != Integer.MAX_VALUE && minDist[edge.to] > minDist[edge.from] + edge.dist) {
                return false;
            }
        }
        // 음수 사이클이 존재하지 않으면 true를 반환합니다.
        return true;
    }

    static class Edge {
        int from, to, dist;

        public Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}