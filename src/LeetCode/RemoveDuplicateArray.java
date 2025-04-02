package LeetCode;

import java.util.Arrays;

public class RemoveDuplicateArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int cnt = removeDuplicates(nums);
        System.out.println(cnt);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, cnt)));
    }
    private static int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
