package LeetCode;
import java.util.*;

public class RemoveElements {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        removeElement(nums, 3);
        int[] expectedNums = new int[]{2,2};
        int k = expectedNums.length;
        Arrays.sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            if(expectedNums[i] != nums[i]){
                System.out.println("FAILED");
                break;
            }
        }
    }
    private static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
