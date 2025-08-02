package LeetCode;

import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println(cd.containsDuplicate(nums)); // Should return true
    }
    List<Integer> list = List.of();
    public boolean containsDuplicate(int[] nums) {
        list = Arrays.stream(nums)
                     .boxed()
                     .toList();
        return list.size() != list.stream().distinct().count();
    }
}
