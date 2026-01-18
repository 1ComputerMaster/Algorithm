package LeetCode;

import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int k = 0;
        SubarraySumEqualsK ssek = new SubarraySumEqualsK();
        System.out.println(ssek.subarraySum(nums, k)); // 2
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new java.util.HashMap<>();
        prefixSumCount.put(0, 1); // 초기값 설정: 합이 0인 경우 1번 카운트
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
