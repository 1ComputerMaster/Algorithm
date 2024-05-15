package BOJ.prefix_sum;

import java.util.*;

public class BOJ_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] sum = new long[N + 1];
        long[] cnt = new long[M];
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + sc.nextLong()) % M;
            if(sum[i] == 0){
                ans++;
            }
            cnt[(int) (sum[i])]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                ans += cnt[i] * (cnt[i] - 1) / 2;
            }
        }
        System.out.println(ans);
    }
}
