package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    static class TreeNode {
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
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = btp.binaryTreePaths(root);
        System.out.println(paths); // Output: ["1->2->5", "1->3"]
    }
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null)
        {
            dfs(root, root.val + "");
        }
        return ans;
    }
    private void dfs(TreeNode root, String sb){
        if(root.left == null && root.right == null){
            ans.add(sb);
            return;
        }
        if(root.left != null)
        {
            dfs(root.left, sb + "->" + root.left.val);
        }
        if(root.right != null)
        {
            dfs(root.right, sb + "->" + root.right.val);
        }
    }

}
