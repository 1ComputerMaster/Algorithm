package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal solution = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        // You can add code here to print or verify the constructed tree
        int child = 0;
        for (TreeNode node : new TreeNode[]{root, root.left, root.right}) {
            System.out.println("Node value: " + node.val + " child count : " + child);
            if (node.left != null && node.right != null) {
                child++;
                System.out.println("Left child: " + node.left.val + ", Right child: " + node.right.val + " child count : " + child);
            } else if (node.left != null) {
                child++;
                System.out.println("Left child: " + node.left.val +  " child count : " + child);
            } else if (node.right != null) {
                child++;
                System.out.println("Right child: " + node.right.val +  " child count : " + child);
            }
        }

    }
    int preIdx = 0;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0, inorder.length);
    }
    private TreeNode dfs(int inLeft, int inRight){
        if (preIdx >= preorder.length || inLeft >= inRight) {
            return null;
        }
        int rootVal = preorder[preIdx++]; // root 공급자
        TreeNode node = new TreeNode(rootVal);
        for(int i = inLeft; i < inRight; i++){
            if(rootVal == inorder[i]){
                node.left = dfs(inLeft, i); //위치 및 범위 분할용 inOrder
                node.right = dfs(i + 1, inRight);
            }
        }
        return node;
    }
}
