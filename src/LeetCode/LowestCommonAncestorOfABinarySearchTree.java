package LeetCode;

public class LowestCommonAncestorOfABinarySearchTree {
/**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while(root != null){
            if(p.val <= root.val && root.val <= q.val){
                return root;
            }else if (p.val < root.val && q.val < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree solution = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = solution.new TreeNode(6);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(8);
        root.left.left = solution.new TreeNode(0);
        root.left.right = solution.new TreeNode(4);
        root.left.right.left = solution.new TreeNode(3);
        root.left.right.right = solution.new TreeNode(5);
        root.right.left = solution.new TreeNode(7);
        root.right.right = solution.new TreeNode(9);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val); // Should print 6
    }
}
