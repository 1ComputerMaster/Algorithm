package LeetCode;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum > target){
                        l--;
                    }else if (sum < target){
                        k++;
                    }else{
                        ans.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

}
