package LeetCode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int i, TreeNode treeNode) {
            this.val = i;
            this.left = treeNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BinarySearchTreeIterator().new BSTIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }
    class BSTIterator {
        private Stack<TreeNode> st = new Stack<>();

        public BSTIterator(TreeNode root) {
            push(root);
        }

        public int next() {
            TreeNode node = st.pop();     // 현재 최소
            if (node.right != null) push(node.right);
            return node.val;
        }

        private void push(TreeNode node) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
    }
}
