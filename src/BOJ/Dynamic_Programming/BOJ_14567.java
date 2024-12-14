package BOJ.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14567 {
    static class Pair implements Comparable<Pair>{
        int from;
        int to;
        public Pair(int from, int to){
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.from, o.from);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Pair[] list = new Pair[M];
        for (int i = 0; i < M; i++){
            list[i] = (new Pair(sc.nextInt(),sc.nextInt()));
        }
        long dp[] = new long[N + 1];

        Arrays.sort(list);

        Arrays.fill(dp, 1);

        for (int i = 0; i < list.length; i++){
            dp[list[i].to] = Math.max(dp[list[i].from] + 1, dp[list[i].to]);
        }
        for (int i = 1; i < N + 1; i++)
            System.out.println(dp[i]);
    }
}
