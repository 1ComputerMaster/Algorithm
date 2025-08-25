package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = i.intersection(nums1, nums2);
        for(int x : result){
            System.out.print(x + " ");
        }
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> idxMap;
        Set<Integer> ans = new HashSet<>();
        idxMap = new HashMap<>();
        for(int x : nums2){
            idxMap.put(x,x);
        }
        for(int a : nums1){
            if(idxMap.containsKey(a)){
                ans.add(a);
            }
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
