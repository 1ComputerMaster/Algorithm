package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans;

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList();
        dfs(candidates, target, 0, new ArrayList());
        return ans;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> cur) {
        if (target < sumList(cur)) {
            return;
        }
        if (target == sumList(cur)) {
            List<Integer> temp = new ArrayList(cur);
            ans.add(temp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, target, i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private int sumList(List<Integer> cur) {
        int s = 0;
        for (int i = 0; i < cur.size(); i++) {
            s += cur.get(i);
        }
        return s;
    }

}
