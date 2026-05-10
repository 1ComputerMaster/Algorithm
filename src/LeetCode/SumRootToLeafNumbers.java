package LeetCode;

public class SumRootToLeafNumbers {
    int ans;

    public static void main(String[] args) {
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(s.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        build(0, root);
        return ans;
    }

    private void build(int path, TreeNode node) {
        if (node == null) return;
        path = path * 10 + node.val;

        if (node.left == null && node.right == null) {
            ans += path;
        }
        build(path, node.left);
        build(path, node.right);

    }

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
    }
}
