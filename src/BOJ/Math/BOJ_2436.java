package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2436 {
    static class Data implements Comparable<Data>{
        int x;
        int y;
        public Data(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare((this.x + this.y),(o.x + o.y));
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        PriorityQueue <Data> pq = new PriorityQueue<>();
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());

        int tmp = B/A;
        for (int i = 1; i <= tmp; i++){
            if(tmp % i == 0){
                int b = tmp / i;
                if(A == GCD(i*A,b*A)) {
                    pq.add(new Data(i, b));
                }
            }
        }
        int x = pq.peek().x * A;
        int y = pq.peek().y * A;
        System.out.println(x > y ? y + " " + x : x + " " + y);
    }
    private static int GCD(int a,int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a%b);
    }
}
