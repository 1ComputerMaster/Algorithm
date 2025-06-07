package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static int n = 0;
    static List<List<Integer>> ansList;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        ansList = new ArrayList<>();
        perm(nums, new ArrayList<>(), new boolean[n]);
        return ansList;
    }
    private void perm(int[] arr, List<Integer> num, boolean[] visited){
        if(n == num.size()){
            ansList.add(new ArrayList<>(num));
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                num.add(arr[i]);
                perm(arr, num, visited);
                num.remove(num.size() - 1);
                visited[i] = false;
            }
        }
    }
}
