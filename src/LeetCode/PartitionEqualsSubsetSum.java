package LeetCode;

public class PartitionEqualsSubsetSum {
    public static void main(String[] args) {
        PartitionEqualsSubsetSum sol = new PartitionEqualsSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(sol.canPartition(nums)); // Example usage
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int goal = sum / 2;
        boolean[] dp = new boolean[goal + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int currSum = goal; currSum >= nums[i]; currSum--){
                dp[currSum] = dp[currSum] || dp[currSum - nums[i]];
                if(dp[goal]) return true;
            }
        }
        return dp[goal];
    }
}
