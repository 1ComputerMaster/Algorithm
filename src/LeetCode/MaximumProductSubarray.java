package LeetCode;

/*
* Kadanes Algorithm Variation
* - 부분합을 구하는 공식을 부분곱으로 변환하여 풀이
* - 음수가 나올 경우 최소곱이 최대곱이 될 수 있으므로, 최대곱과 최소곱을 각각 저장
* */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        int[] nums = {2,3,-2,4};
        System.out.println(obj.maxProduct(nums)); // 6
    }
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr)); // because of negative filp the sign
            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

}
