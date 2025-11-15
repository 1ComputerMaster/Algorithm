package LeetCode;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        System.out.println(sol.rob(new int[]{1, 2, 3, 1})); // Example usage
    }
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;

        if(nums.length > 2){
            dp[1] = nums[1];
            dp[2] = Math.max(nums[2], dp[0] + nums[2]);
            max = Math.max(max, Math.max(dp[1], dp[2]));
        }else{
            return Math.max(nums[0], nums[1]);
        }
        for(int i = 3; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i - 3] + nums[i], dp[i - 2] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
