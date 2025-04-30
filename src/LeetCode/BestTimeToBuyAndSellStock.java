package LeetCode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int diff = 0;
        int buyProfit = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(buyProfit > prices[i]){
                buyProfit = prices[i];
            }
            if(prices[i] - buyProfit > diff){
                diff = prices[i] - buyProfit;
            }
        }
        return diff;
    }
}
