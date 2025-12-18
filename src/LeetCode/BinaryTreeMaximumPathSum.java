package LeetCode;

public class BinaryTreeMaximumPathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        TreeNode root = btmps.new TreeNode(-10);
        root.left = btmps.new TreeNode(9);
        root.right = btmps.new TreeNode(20);
        root.right.left = btmps.new TreeNode(15);
        root.right.right = btmps.new TreeNode(7);
        System.out.println(btmps.maxPathSum(root)); // Should print 42
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }
    private int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        // 하부 트리의 음수 단의 값은 버려도 되니 버린다.
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        // 다만, 현재 위치에서 최대 경로 갱신시 하부 트리 및 중간 값을 고려하여야 하므로 따로 전역변수로 이 부분을 관리한다.
        ans = Math.max(ans, (left + right + root.val));
        return Math.max(left, right) + root.val;
    }

}
