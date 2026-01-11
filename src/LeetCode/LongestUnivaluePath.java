package LeetCode;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(root));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        longest = 0;

        dfs(root);
        return longest;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int rightPath = 0;
        int leftPath = 0;

        if(node.left != null && node.val == node.left.val)
        {
            leftPath = left + 1;
        }
        if(node.right != null && node.val == node.right.val)
        {
            rightPath = right + 1;
        }

        longest = Math.max(longest, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }

}
