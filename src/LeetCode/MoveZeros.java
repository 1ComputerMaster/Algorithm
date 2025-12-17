package LeetCode;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // Should print [1, 3, 12, 0, 0]
    }
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[idx++] = nums[i];
            }
        }
        Arrays.fill(nums,idx,nums.length,0);
    }
}
