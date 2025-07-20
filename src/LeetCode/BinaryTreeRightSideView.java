package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);

        List<Integer> rightView = btrsv.rightSideView(root);
        System.out.println(rightView); // Should print [1, 3, 5]
    }
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    private void dfs(TreeNode node, int depth, List<Integer> view) {
        if (node == null) return;
        // 깊이 == view.size()이면 첫 방문이므로 값 기록
        if (depth == view.size()) {
            view.add(node.val);
        }
        // 우측 자식부터 탐색
        dfs(node.right, depth + 1, view);
        dfs(node.left,  depth + 1, view);
    }

    /* 비효율적인 방법 - 1
    static Map<Integer,Integer> ans = new HashMap();
    static int maxDegree = 0;
    public List<Integer> rightSideView(TreeNode root) {
        ans.clear();
        dfs(root, 0, true);
        List<Integer> valueList = new ArrayList(ans.values());
        return valueList;
    }
    private void dfs(TreeNode cur, int degree, boolean rcheck){
        if(rcheck && cur != null){
            ans.put(degree, cur.val);
            if(ans.getOrDefault(degree, -1) == -1){
                ans.put(degree, cur.val);
                maxDegree = Math.max(degree, maxDegree);
            }
        } else if (!rcheck && cur != null){
            if(ans.getOrDefault(degree, -1) == -1){
                ans.put(degree, cur.val);
                maxDegree = Math.max(degree, maxDegree);
            }
        }else{
            return;
        }
        if(rcheck){
            if(cur.right != null)
                dfs(cur.right, degree + 1, true);
            if(cur.left != null)
                dfs(cur.left, degree + 1, false);
        }else{
            if(cur.right != null)
                dfs(cur.right, degree + 1, false);
            if(cur.left != null)
                dfs(cur.left, degree + 1, false);

        }

    }
    * */
}
