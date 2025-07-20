package LeetCode;

public class InvertBinaryTree {
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
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = ibt.invertTree(root);
        // Output the inverted tree structure or values as needed
        System.out.println(invertedRoot.val); // Should print 4
        System.out.println(invertedRoot.left.val); // Should print 7
        System.out.println(invertedRoot.right.val); // Should print 2
        System.out.println(invertedRoot.left.left.val); // Should print 9
        System.out.println(invertedRoot.left.right.val); // Should print 6
        System.out.println(invertedRoot.right.left.val); // Should print 3
        System.out.println(invertedRoot.right.right.val); // Should print 1

    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode ans = new TreeNode();
        return dfs(root);
    }
    private TreeNode dfs(TreeNode root){
        if (root == null) {
            return null;
        }
        // 현재 노드 복제
        TreeNode newNode = new TreeNode(root.val);
        if(root.right != null){
            newNode.left = dfs(root.right);
        }
        if(root.left != null){
            newNode.right = dfs(root.left);
        }
        return newNode;
    }
}
