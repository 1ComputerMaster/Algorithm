package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderandInorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPostorderandInorderTraversal solution = new ConstructBinaryTreeFromPostorderandInorderTraversal();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(TreeNodeToString(root));
    }

    private static String TreeNodeToString(TreeNode root) {
        if (root == null) return "null";
        return root.val + " -> (" + TreeNodeToString(root.left) + ", " + TreeNodeToString(root.right) + ")";
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int[] postOrder;
    static int postIdx;
    static int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        postIdx = postorder.length - 1;
        this.inorder = inorder;
        return dfs(0, inorder.length);
    }
    private TreeNode dfs(int inLeft, int inRight){
        if (postIdx < 0 || inLeft >= inRight) {
            return null;
        }
        int rootVal = postOrder[postIdx--]; // root 공급자
        TreeNode node = new TreeNode(rootVal);
        for(int i = inLeft; i < inRight; i++){
            if(rootVal == inorder[i]){
                node.right = dfs(i + 1, inRight);
                node.left = dfs(inLeft, i); //위치 및 범위 분할용 inOrder
                break;
            }
        }
        return node;
    }
}
