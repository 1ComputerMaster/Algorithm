package LeetCode;
import java.util.*;

public class Majority_Element {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,3,4}));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxVal = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(maxVal < entry.getValue()){
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
