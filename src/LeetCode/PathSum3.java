package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    public static void main(String[] args) {
        PathSum3 sol = new PathSum3();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int targetSum = 8;
        int result = sol.pathSum(root, targetSum);
        System.out.println(result); // Should print the number of paths that sum to targetSum
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        dfs(root, 0, targetSum);
        return ans;
    }
    Map<Integer, Integer> prefixSumCount;
    private void dfs(TreeNode node, int prefixSum, int targetSum){
        if(node == null) return;
        prefixSum += node.val;
        int prevSum = prefixSum - targetSum;
        ans += prefixSumCount.getOrDefault(prevSum, 0);
        prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        dfs(node.left, prefixSum, targetSum);
        dfs(node.right, prefixSum, targetSum);
        prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) - 1);
    }


    /*
    * DFS로 모든 노드를 순회하면서 각 노드를 시작점으로 하는 경로의 합을 구한다.
    * 바깥 DFS는 모든 노드를 순회하고, 안쪽 DFS는 각 노드에서 시작하는 경로의 합을 계산한다.
    * */
//    private void dfs2(TreeNode root, int targetSum){
//        if(root == null) return;
//        dfs(root, Long.valueOf(targetSum));
//        dfs2(root.left, targetSum);
//        dfs2(root.right, targetSum);
//    }
//    private void dfs(TreeNode root, long targetSum){
//        if(root == null){
//            return;
//        }
//        if(targetSum == root.val){
//            ans += 1;
//        }
//        dfs(root.left, targetSum - root.val);
//        dfs(root.right, targetSum - root.val);
//    }
}
