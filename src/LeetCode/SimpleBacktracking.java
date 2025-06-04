package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SimpleBacktracking {
    public static void main(String[] args) {
        int n = 4, k = 2;
        combine(n, k);
    }
    static List<List<Integer>> ansList;
    static boolean[] visited;
    public static List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n];
        ansList = new ArrayList<>();
        comb(n, 0, 0, k, new ArrayList());
        return ansList;
    }
    private static void comb(int n, int cnt, int start, int k, List<Integer> nums){
        if(k == cnt){
            ansList.add(new ArrayList<>(nums));
            return;
        }
        for(int i = start; i < n; i++){
            nums.add(i + 1);
            comb(n, cnt + 1, i + 1, k, nums);
            nums.remove(nums.size() - 1);
        }
    }
}
