package LeetCode;

public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 solution = new HouseRobber2();
        int[] nums = {2, 3, 2};
        System.out.println(solution.rob(nums)); // Should print 3
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        return Math.max(
                robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
