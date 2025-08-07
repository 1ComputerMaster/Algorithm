package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        ContainsDuplicate2 cd2 = new ContainsDuplicate2();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(cd2.containsNearbyDuplicate(nums, k)); // Should print true

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println(cd2.containsNearbyDuplicate(nums, k)); // Should print true

        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println(cd2.containsNearbyDuplicate(nums, k)); // Should print false
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (seen.containsKey(val) && i - seen.get(val) <= k) {
                return true;
            }
            seen.put(val, i);
        }

        return false;

    }
}
