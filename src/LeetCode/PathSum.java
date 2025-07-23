package LeetCode;

public class PathSum {
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

        public TreeNode(int i, TreeNode treeNode) {
            this.val = i;
            this.left = treeNode;
        }
    }
    public static void main(String[] args) {
        PathSum ps = new PathSum();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2))), new TreeNode(8, null, new TreeNode(4, null, new TreeNode(1))));
        int sum = 22;
        System.out.println(ps.hasPathSum(root, sum)); // Should return true
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }
}
