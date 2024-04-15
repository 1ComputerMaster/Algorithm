package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2141 {
    static class Data implements Comparable<Data>{
        int point;
        int people;
        public Data(int point, int people){
            this.point = point;
            this.people = people;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.point,o.point);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        PriorityQueue<Data> pq = new PriorityQueue<Data>();
        long total = 0;
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int point = Integer.parseInt(tk.nextToken());
            int people = Integer.parseInt(tk.nextToken());
            pq.add(new Data(point,people));
            total += people;
        }
        long sum = 0;
        while(!pq.isEmpty()){
            Data now = pq.poll();
            sum += now.people;
            if((total + 1) / 2 <= sum){
                System.out.println(now.point);
                break;
            }
        }
    }
}
