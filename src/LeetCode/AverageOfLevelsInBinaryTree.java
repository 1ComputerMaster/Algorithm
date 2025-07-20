package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    long[] ans;
    long[] cnt;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
        List<Double> averages = solution.averageOfLevels(root);
        System.out.println(averages); // Output: [3.0, 14.5, 11.0]
    }
    public List<Double> averageOfLevels(TreeNode root) {
        ans = new long[10001];
        cnt = new long[10001];
        dfs(root, 0);
        List<Double> ansList = new ArrayList<>();
        for(int i = 0; i < 10001; i++){
            if(cnt[i] == 0){
                break;
            }
            ansList.add(Double.valueOf((double)ans[i] / (double)cnt[i]));
        }
        return ansList;
    }
    private void dfs(TreeNode cur, int degree){
        if(cur != null){
            ans[degree] += cur.val;
            cnt[degree]++;
            dfs(cur.left, degree + 1);
            dfs(cur.right, degree + 1);
        }
        return;
    }
}
