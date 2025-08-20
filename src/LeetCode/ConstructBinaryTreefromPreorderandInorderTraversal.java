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
    static int preIdx;
    static Map<Integer, Integer> inOrderMap;
    static int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        this.preorder = preorder;
        inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }
    private TreeNode build(int inL, int inR){
        if(inL > inR) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderMap.get(rootVal);
        root.left = build(inL, mid - 1);
        root.right = build(mid + 1, inR);
        return root;
    }
}
