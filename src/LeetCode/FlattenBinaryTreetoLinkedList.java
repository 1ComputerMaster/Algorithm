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
        if (node == null) return null;
        TreeNode leftTail = flat(node.left); //4
        TreeNode rightTail = flat(node.right); //6
        if (node.left != null) {
            TreeNode saved = node.right;
            node.right = node.left;
            node.left = null;
            leftTail.right = saved;
        }
        if (rightTail != null) return rightTail; // 오른쪽이 붙었다면 전체 꼬리는 그 끝
        else if (leftTail != null) return leftTail; // 오른쪽이 없고 왼쪽만 있다면 왼쪽 끝
        else return node; // 둘 다 없으면 리프가 곧 꼬리
    }

}
