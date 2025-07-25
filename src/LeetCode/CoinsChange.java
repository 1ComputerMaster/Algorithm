package LeetCode;

import java.util.Arrays;

public class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[10001];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 0; i < 10001; i++){
            for(int c : coins){
                if(i - c < dp.length && i - c >= 0)
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinsChange cc = new CoinsChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount)); // Output: 3 (11 = 5 + 5 + 1)

        coins = new int[]{2};
        amount = 3;
        System.out.println(cc.coinChange(coins, amount)); // Output: -1 (not possible to make change)
    }
}
