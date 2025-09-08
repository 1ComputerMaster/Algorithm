package LeetCode;

import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();

        while(root != null){
            st.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
