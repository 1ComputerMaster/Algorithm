package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfaBinaryTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorOfaBinaryTree solution = new LowestCommonAncestorOfaBinaryTree();
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val); // Output: 3
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);

        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) i++;
        return pPath.get(i - 1);
    }
    private boolean findPath(TreeNode node, TreeNode target, List<TreeNode> path){
        if (node == null) return false;
        path.add(node);
        if (node == target) return true;
        if(findPath(node.left, target, path) || findPath(node.right, target, path)){
            return true;
        }else{
            path.remove(path.size() - 1);
        }
        return false;
    }
}
