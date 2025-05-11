package LeetCode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int curr = 1;
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        for(int i = 0; i < nums.length; i++){
            answer[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            answer[i] *= curr;
            curr *= nums[i];
        }
        return answer;
    }
}
