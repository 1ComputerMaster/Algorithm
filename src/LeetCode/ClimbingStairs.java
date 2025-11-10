package LeetCode;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i < 46; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}