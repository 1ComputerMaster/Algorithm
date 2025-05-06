package BOJ.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int ans = 0;
            int J = sc.nextInt();
            int N = sc.nextInt();

            Queue<Integer> pq = new PriorityQueue<>(
                    Comparator.reverseOrder()
            );

            for (int i = 0; i < N; i++){
                pq.add(sc.nextInt() * sc.nextInt());
            }
            while (J > 0) {
                if(!pq.isEmpty())
                {
                    J -= pq.poll();
                }
                ans++;
                if (J <= 0) {
                    System.out.println(ans);
                }
            }
        }
    }
}
