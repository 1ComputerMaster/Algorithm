package LeetCode;

import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ConvertSortedArrayToBinarySearchTree cv = new ConvertSortedArrayToBinarySearchTree();
        cv.inorder(cv.sortedArrayToBST(nums), 0);
        List<Integer> printList = new ArrayList<>();
        for (int i = 0; i < depthMap.size(); i++){
            printList.addAll(depthMap.get(i));
        }
        System.out.print(printList.toString());

    }
    static Map<Integer, List<Integer>> depthMap = new HashMap<>();
    public void inorder(TreeNode cur, int depth){
        if(cur != null){
            depthMap.computeIfAbsent(depth, k -> new ArrayList<>()).add(cur.val);
            inorder(cur.left, depth + 1);
            inorder(cur.right, depth + 1);
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }
    private TreeNode convert(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convert(nums, left, mid - 1);
        node.right = convert(nums, mid + 1, right);

        return node;
    }

}
