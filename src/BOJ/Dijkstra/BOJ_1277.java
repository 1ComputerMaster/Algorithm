package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1277 {
    static int N,W;
    static double M;
    static List<Data>[] graph;

    static class Map{
        double x;
        double y;
        public Map(double x,double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Data implements Comparable<Data>{
        int to;
        double weight;
        public Data(int to, double weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Data o) {
            return Double.compare(this.weight, o.weight);
        }
    }
public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        W = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(in.readLine()," ");

        M = Double.parseDouble(tk.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<Data>();
        }
        List<Map> map = new ArrayList<>();
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            map.add(new Map(Double.parseDouble(tk.nextToken()),Double.parseDouble(tk.nextToken())));
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++) {
                if(i != j){
                    double distX = map.get(i - 1).x - map.get(j - 1).x;
                    double distY = map.get(i - 1).y - map.get(j - 1).y;
                    double dist = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
                    graph[i].add(new Data(j, dist));
                    graph[j].add(new Data(i, dist));
                }
            }
        }
        for (int i = 0; i < W; i++){
            tk = new StringTokenizer(in.readLine()," ");

            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());

            graph[from].add(new Data(to, 0));
            graph[to].add(new Data(from, 0));
        }

        double res = dijkstra();
        System.out.println((long) (res *1000));
    }

    private static double dijkstra() {
        PriorityQueue<Data> q = new PriorityQueue<>();
        q.offer(new Data(1, 0));
        double[] dist = new double[N + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[1] = 0;
        while (!q.isEmpty()) {
            Data now = q.poll();
            if (now.weight > dist[now.to]) continue;
            for (Data next : graph[now.to]) {
                if (dist[next.to] > dist[now.to] + next.weight) {
                    dist[next.to] = dist[now.to] + next.weight;
                    q.offer(new Data(next.to, dist[next.to]));
                }
            }
        }
        return dist[N];
    }
}