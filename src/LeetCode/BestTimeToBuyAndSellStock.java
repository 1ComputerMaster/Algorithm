package LeetCode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int j = 0; j < prices.length; j++){
            if(min > prices[j]){
                min = prices[j];
            }
            else if (prices[j] - min > profit){
                profit = prices[j] - min;
            }
        }
        return profit;
    }
}
