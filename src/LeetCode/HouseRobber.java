package LeetCode;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // Example usage
    }
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 0; i < nums.length - 2; i++){
            if(i + 3 < nums.length){
                dp[i + 2] = Math.max(dp[i] + nums[i + 2], dp[i + 2]);
                dp[i + 3] = Math.max(dp[i] + nums[i + 3], dp[i + 3]);
            }else{
                dp[i + 2] = Math.max(dp[i] + nums[i + 2], dp[i + 2]);
            }
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
