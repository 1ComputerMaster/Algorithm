package LeetCode;

public class CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        TreeNode root = c.new TreeNode(1);
        root.left = c.new TreeNode(2);
        root.right = c.new TreeNode(3);
        root.left.left = c.new TreeNode(4);
        root.left.right = c.new TreeNode(5);
        root.right.left = c.new TreeNode(6);

        System.out.println(c.countNodes(root)); // Should return 6
    }

    public int countNodes(TreeNode root) {
        return cnt(root);
    }

    private int cnt(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int cnt = 0;
        cnt += countNodes(root.left);
        cnt += countNodes(root.right);
        return cnt + 1;
    }

}
