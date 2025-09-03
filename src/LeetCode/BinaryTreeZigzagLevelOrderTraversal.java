package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

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
        BinaryTreeZigzagLevelOrderTraversal btz = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = btz.zigzagLevelOrder(root);
        System.out.println(result); // Should print [[3], [20, 9], [15, 7]]
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if(curr != null){

            if(sol.size() <= level){
                List<Integer> collection = new ArrayList();
                sol.add(collection);
            }

            List<Integer> travelLevel = sol.get(level);

            if(level%2 == 0){
                travelLevel.add(curr.val);
            }else{
                travelLevel.add(0, curr.val);
            }
            travel(curr.left, sol, level + 1);
            travel(curr.right, sol, level + 1);
        }
    }

}
