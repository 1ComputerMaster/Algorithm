package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums)); // Should print 4
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max = 0;

        for(int x : numSet){

            if(!numSet.contains(x - 1)){
                int length = 1;

                while(numSet.contains(x + length)){
                    length++;
                }

                max = Math.max(max, length);
            }
        }
        return max;
    }

}
