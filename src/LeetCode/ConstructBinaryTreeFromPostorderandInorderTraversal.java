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
    static Map<Integer, Integer> inOrderMap;
    static int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        postOrder = postorder;
        postIdx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }
    private TreeNode build(int inL, int inR){
        if(inL > inR) return null;
        int rootVal = postOrder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderMap.get(rootVal);
        root.right = build(mid + 1, inR);
        root.left = build(inL, mid - 1);
        return root;
    }
}
