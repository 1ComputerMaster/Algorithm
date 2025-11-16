package LeetCode;

import java.util.Arrays;

public class PerfactSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12)); // Example usage
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 이터레이션을 통해서 초기화를 실시한다.
        // 1 iteration (1) - [0], [1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12]
        // 2 iteration (4) - [0], [1], [2], [3], [1], [2], [3], [4], [2], [3], [4], [5], [3]
        while(count * count <= n){
            for(int i = count * count; i <= n; i++){
                dp[i] = Math.min(dp[i], dp[i - count * count] + 1);
            }
            count++;
        }
        return dp[n];
    }
}
