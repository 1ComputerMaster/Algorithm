package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_15624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] dp = new int[N + 1];
        if(N > 2) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 2; i <= N; i++){
                dp[i] = (dp[i - 1] % 1_000_000_007 + dp[i - 2] % 1_000_000_007) % 1_000_000_007;
            }
            System.out.println(dp[N]);
        }
        else{
            if(N == 2 || N == 1){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
