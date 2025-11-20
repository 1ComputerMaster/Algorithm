package LeetCode;

import java.util.Arrays;

public class CoinsChange {
    /**
    * dp[i] = i원을 만드는데 필요한 최소 동전 개수
    *  dp[0] = 0
    *  for i from 1 to amount:
    *   for coin in coins:
    *   if i - coin >= 0:
    *   dp[i] = min(dp[i], dp[i - coin] + 1)
    *   return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount]
    *
    **/
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 0; i < amount + 1; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] < amount + 1 && i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
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
