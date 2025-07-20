package LeetCode;


public class SymmetricTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(st.isSymmetric(root)); // Should return true
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);

    }
}
