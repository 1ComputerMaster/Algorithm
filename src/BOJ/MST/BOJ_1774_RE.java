package BOJ.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1774_RE {
    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Point implements Comparable<Point>{
        int where;
        double weight;
        public Point(int where, double weight){
            this.where = where;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Data> pointList = new ArrayList<>();
        ArrayList<Point>[] weightList = new ArrayList[N];
        for (int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            pointList.add(new Data(x,y));
            weightList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (i == j){
                    continue;
                }
                double weight = Math.sqrt(Math.pow(Math.abs(pointList.get(i).x - pointList.get(j).x), 2.0) +
                        Math.pow(Math.abs(pointList.get(i).y - pointList.get(j).y), 2.0));
                weightList[i].add(new Point(j,weight));
                weightList[j].add(new Point(i,weight));
            }
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++){
            int pointFirst = sc.nextInt() - 1;
            int pointSecond = sc.nextInt() - 1;
            weightList[pointSecond].add(new Point(pointFirst, 0.0));
            weightList[pointFirst].add(new Point(pointSecond, 0.0));
        }

        MST(weightList, N);
    }

    private static void MST(ArrayList<Point>[] graph, int N) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0));
        boolean[] visited = new boolean[N];
        double res = 0;
        while (!pq.isEmpty()){
            Point point = pq.poll();
            if(visited[point.where]){
                continue;
            }
            visited[point.where] = true;
            res += point.weight;
            for (Point next : graph[point.where]){
                if(!visited[next.where])
                {
                    pq.add(next);
                }
            }
        }
        System.out.printf("%.2f",Math.round(res * 100) / 100.0);
    }
}
