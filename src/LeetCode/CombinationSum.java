package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> ansList;
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ansList = new ArrayList<>();
        comb(0,candidates,target, new ArrayList());
        return ansList;
    }
    private static void comb(int start ,int[] candidates, int target, List<Integer> arr){
        if(target < 0) return;
        if(target == 0){
            List<Integer> temp = new ArrayList(arr);
            ansList.add(temp);
            return;
        }
        for(int i = start; i < candidates.length; i++){
            arr.add(candidates[i]);
            comb(i, candidates, target - candidates[i], arr);
            arr.remove(arr.size() - 1);
        }
    }

}
