package LeetCode;

import java.util.*;

public class ThreeOfSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,1,-1}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> distinctList = new HashSet<>();
        List<List<Integer>> ansList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int left = i + 1;
            int target = nums[i];
            int right = n - 1;
            while (left < right) {
                if (left != i && right != i) {
                    if (target + (nums[left] + nums[right]) == 0) {
                        if(!distinctList.contains(List.of(target, nums[left], nums[right]))){
                            distinctList.add(List.of(target, nums[left], nums[right]));
                            ansList.add(List.of(target, nums[left], nums[right]));
                        }
                    }
                    if (target + (nums[left] + nums[right]) < 0) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ansList;
    }

}
