package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    public static void main(String[] args) {
        BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = b.postorderTraversal(root);
        System.out.println(result); // Should print [3, 2, 1]
    }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            dfs(root);
            return ans;
        }
        return List.of();
    }
    private void dfs(TreeNode cur){
        if(cur.left != null)
            dfs(cur.left);
        if(cur.right != null)
            dfs(cur.right);
        if(cur != null){
            ans.add(cur.val);
        }
    }
}
