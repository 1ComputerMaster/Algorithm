package LeetCode;

public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
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
        FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
        TreeNode root = f.new TreeNode(1);
        root.left = f.new TreeNode(2);
        root.right = f.new TreeNode(5);
        root.left.left = f.new TreeNode(3);
        root.left.right = f.new TreeNode(4);
        root.right.right = f.new TreeNode(6);

        f.flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public void flatten(TreeNode root) {
        root = flat(root);
    }

    private TreeNode flat(TreeNode node) {
        if(node == null) return null;

        TreeNode leftTail = flat(node.left);
        TreeNode rightTail = flat(node.right);

        if(node.left != null) {
            TreeNode savedRight = node.right;
            node.right = node.left;
            node.left = null;
            leftTail.right = savedRight;
        }
        if(rightTail != null) {
            return rightTail;
        }
        if(leftTail != null) {
            return leftTail;
        }
        return node;
    }

}
