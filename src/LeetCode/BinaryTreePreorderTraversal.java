package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
        BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = b.preorderTraversal(root);
        System.out.println(result); // Should print [1, 2, 3]
    }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null)
        {
            dfs(root);
        }
        return ans;
    }
    private void dfs(TreeNode root){
        if(root != null){
            ans.add(root.val);
        }
        if(root.left != null)
            dfs(root.left);
        if(root.right != null)
            dfs(root.right);
    }
}
