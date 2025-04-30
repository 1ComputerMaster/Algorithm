package LeetCode;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];

        k = nums.length - (k % nums.length);

        for(int i = k; i < nums.length + k; i++){
            temp[i - k] = nums[(i % nums.length)];
        }

        for(int i = 0; i < temp.length; i++){
            nums[i] = temp[i];
        }
    }
}
