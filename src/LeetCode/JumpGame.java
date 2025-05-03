package LeetCode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++){
            if(i > farthest){
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}