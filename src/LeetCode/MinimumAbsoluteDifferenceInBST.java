package LeetCode;

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();
        int result = solution.getMinimumDifference(root);
        System.out.println("Minimum absolute difference: " + result); // Output: 1
    }
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }

    private void find(TreeNode root){
        if(root == null){
            return;
        }

        find(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }


        prev = root;
        find(root.right);
        return ;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
