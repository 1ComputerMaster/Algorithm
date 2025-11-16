package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,1,1,0,5}, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            cnt = map.getOrDefault(target - nums[i], -1);
            if(cnt != -1 && i != cnt){
                return new int[] {i, cnt};
            }
        }
        return new int[]{};
    }
}
