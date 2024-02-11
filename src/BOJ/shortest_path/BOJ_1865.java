package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static class Edge{
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int N,M,W;
    static List<Edge> graph;
    static long[] minDist;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int T = Integer.parseInt(tk.nextToken());

        while (T-- > 0){
            tk = new StringTokenizer(in.readLine()," ");
            N = Integer.parseInt(tk.nextToken());
            M = Integer.parseInt(tk.nextToken());
            W = Integer.parseInt(tk.nextToken());
            minDist = new long[N + 1];
            Arrays.fill(minDist, 100_000_000);
            graph = new ArrayList<Edge>();

            for (int i = 0; i < M; i++){
                tk = new StringTokenizer(in.readLine()," ");
                int S = Integer.parseInt(tk.nextToken());
                int E = Integer.parseInt(tk.nextToken());
                int D = Integer.parseInt(tk.nextToken());
                graph.add(new Edge(S,E,D));
                graph.add(new Edge(E,S,D));

            }

            for (int i = 0; i < W; i++){
                tk = new StringTokenizer(in.readLine()," ");
                int S = Integer.parseInt(tk.nextToken());
                int E = Integer.parseInt(tk.nextToken());
                int D = Integer.parseInt("-" + tk.nextToken());
                graph.add(new Edge(S,E,D));
            }

            if(belmanFord()){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }

    private static boolean belmanFord() {
        minDist[1] = 0;
        for (int i = 0; i < N - 1 + M; i++){
            for (Edge edge : graph){
                if(minDist[edge.to] > minDist[edge.from] + edge.weight){
                    minDist[edge.to] = minDist[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : graph){
            if(minDist[edge.to] > minDist[edge.from] + edge.weight){
                return false;
            }
        }
        return true;
    }
}
