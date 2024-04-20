package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_13975 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(tk.nextToken());
        PriorityQueue<Long> pq;
        while (T-- > 0){
            tk = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(in.readLine());
            pq = new PriorityQueue<Long>();
            while (tk.hasMoreTokens()){
                long tmp = Long.parseLong(tk.nextToken());
                pq.add(tmp);
            }
            long sum = 0L;
            while (pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                sum += a + b;
                pq.offer(a + b);
            }
            System.out.println(sum);
        }
    }
}
