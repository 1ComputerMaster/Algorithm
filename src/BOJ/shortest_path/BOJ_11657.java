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

        long[] minDist = new long[N + 1];
        Arrays.fill(minDist, 100_000_000);

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");

            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            int dist = Integer.parseInt(tk.nextToken());
            edges.add(new Edge(from, to, dist));
        }

        if(bellmanFord(edges, minDist)){
            for (int i = 2; i <= N; i++) {
                if(minDist[i] == 100_000_000){
                    System.out.println("-1");
                }
                else {
                    System.out.println(minDist[i]);
                }
            }
        }
        else {
            System.out.println("-1");
        }
    }

    private static boolean bellmanFord(List<Edge> edges, long[] minDist) {
        boolean check = true;
        minDist[1] = 0;
        for (int i = 0; i < N - 1; i++){
            for (Edge edge : edges){
                if(minDist[edge.from] != 100_000_000 && minDist[edge.to] > minDist[edge.from] + edge.dist){
                    minDist[edge.to] = minDist[edge.from] + edge.dist;
                }
            }
        }
        for (Edge edge : edges){
            if (minDist[edge.from] != 100_000_000 && minDist[edge.to] > minDist[edge.from] + edge.dist){
                check = false;
            }
        }
        return check;
    }

    static class Edge{
        int from;
        int to;
        int dist;
        public Edge(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}
