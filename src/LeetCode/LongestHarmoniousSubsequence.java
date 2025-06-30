package LeetCode;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 4, 3})); // Example usage
    }
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }

}
