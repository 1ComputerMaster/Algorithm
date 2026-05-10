package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> ans;

    public static void main(String[] args) {
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = b.inorderTraversal(root);
        System.out.println(result); // Should print [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
