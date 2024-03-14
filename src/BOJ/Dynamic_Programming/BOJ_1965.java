package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_1965 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        int ans = 0;
        for (int i = 1; i < N; i++){
            for (int j = i - 1; j >= 0; j--){
                if(dp[i] < dp[j] + 1 && arr[i] > arr[j]){
                    dp[i] = dp[j] + 1;
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        System.out.println(ans + 1);
    }
}
