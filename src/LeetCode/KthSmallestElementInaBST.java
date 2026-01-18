package LeetCode;

public class KthSmallestElementInaBST {
    public static void main(String[] args) {
        KthSmallestElementInaBST k = new KthSmallestElementInaBST();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int kValue = 1;
        System.out.println(k.kthSmallest(root, kValue)); // Should return 1
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
    private int count = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;

    }
    private void inorderTraversal(TreeNode node, int k) {
        if(node == null || count >= k){
            return;
        }
        inorderTraversal(node.left, k);
        count++;
        if(count == k){
            result = node.val;
            return;
        }
        inorderTraversal(node.right, k);
    }
}
