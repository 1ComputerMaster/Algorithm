package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal btl = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = btl.levelOrder(root);
        System.out.println(result); // Should print [[1], [2, 3], [4, 5]]
    }

    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> rootList = new ArrayList();
        if (root != null) {
            rootList.add(root.val);
        } else {
            return ansList;
        }
        ansList.add(rootList);
        List<Integer> nextList = new ArrayList();
        getTreeVal(root.left, 1);
        getTreeVal(root.right, 1);
        return ansList;
    }

    private void getTreeVal(TreeNode cur, int degree) {
        if (cur != null) {
            if (ansList.size() > degree) {
                ansList.get(degree).add(cur.val);
            } else {
                ansList.add(degree, new ArrayList());
                ansList.get(degree).add(cur.val);
            }
        } else {
            return;
        }
        if (cur.left != null) {
            getTreeVal(cur.left, degree + 1);
        }
        if (cur.right != null) {
            getTreeVal(cur.right, degree + 1);
        }
    }
}
