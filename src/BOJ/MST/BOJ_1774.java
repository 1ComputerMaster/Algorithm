package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774 {
    static class Data implements Comparable<Data>{
        int x;
        double y;
        public Data(int x, double y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Data o) {
            return Double.compare(this.y, o.y);
        }
    }
    static boolean visited[];
    static List<Data>[] list;
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        int[] x = new int[N];
        int[] y = new int[N];

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            x[i] = Integer.parseInt(tk.nextToken());
            y[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                long distX = (long) (Math.abs(x[i] - x[j])) * (Math.abs(x[i] - x[j]));
                long distY = (long) (Math.abs(y[i] - y[j])) * (Math.abs(y[i] - y[j]));
                double dist = Math.sqrt(distY + distX);
                list[i].add(new Data(j , dist));
                list[j].add(new Data(i , dist));
            }
        }
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int to = Integer.parseInt(tk.nextToken());
            int from = Integer.parseInt(tk.nextToken());
            list[to - 1].add(new Data(from - 1 , 0.0));
            list[from - 1].add(new Data(to - 1 , 0.0));
        }
        double res = Prim();
        System.out.printf("%.2f\n", res);
    }
    private static double Prim(){
        PriorityQueue<Data> q = new PriorityQueue<Data>();
        double res = 0.0;

        q.offer(new Data(0, 0.0));
        while(!q.isEmpty()) {
            Data cur = q.poll();
            if(visited[cur.x]) {
                continue;
            }
            visited[cur.x] = true;
            res += cur.y;
            for (int j = 0; j < list[cur.x].size(); j++) {
                if(!visited[list[cur.x].get(j).x]) {
                    q.offer(new Data(list[cur.x].get(j).x,list[cur.x].get(j).y));
                }
            }
        }
        return res;
    }
}
