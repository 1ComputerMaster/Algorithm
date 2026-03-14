package LeetCode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        arrayReverse(nums, 0, n - 1);
        arrayReverse(nums, 0, k - 1);
        arrayReverse(nums, k, n - 1);
    }

    private static void arrayReverse(int[] nums, int s, int e) {
        while(e > s){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            e--;
            s++;
        }
    }
}
