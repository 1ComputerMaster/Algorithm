package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    List<List<Integer>> ans;

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        System.out.println(permutations.permute(new int[] {1,2,3}));

    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        perm(new boolean[nums.length], nums, 0, new ArrayList());
        return ans;
    }
    private void perm(boolean[] visited, int[] nums, int cnt, List<Integer> cur){
        if(cnt == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                perm(visited, nums, cnt + 1, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
