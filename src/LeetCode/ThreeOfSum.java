package LeetCode;

import java.util.*;

public class ThreeOfSum {
    public static void main(String[] args) {
        ThreeOfSum t = new ThreeOfSum();
        System.out.println(t.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //1. 한 개 뽑아서 two pointer(left, right)로 그 값 0 만드는 수 찾기
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet();
        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0){
                    set.add(List.of(nums[start],nums[i],nums[end]));
                    start++;
                    end--;
                }
                else if(sum < 0){
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return new ArrayList(set);
    }

}
