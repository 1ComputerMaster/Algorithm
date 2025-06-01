package LeetCode;

import java.util.Objects;


public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode right;

    }

    public static void main(String[] args) {
        // 예시 트리 생성
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)
                )
        );
        System.out.println("Max Depth: " + maxDepth(root)); // 예: 3 출력
    }

    // 풀이 3 : DFS
    public static int maxDepth(TreeNode root) {
        if(!Objects.nonNull(root)){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /*
    풀이 2 BFS
    public static int maxDepth(TreeNode root) {
        if(!Objects.nonNull(root))
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add((root));
        int maxDepth = 0;
        while(!q.isEmpty()){
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            maxDepth += 1;
        }
        return maxDepth;
    }
*/


/*  풀이 1 BFS
    public static int maxDepth(TreeNode root) {
        Queue<Data> q = new LinkedList<Data>();
        q.add(new Data(root, 1));
        if(!Objects.nonNull(root))
        {
            return 0;
        }
        int maxDepth = 1;
        while(!q.isEmpty()){
            Data cur = q.poll();
            if(Objects.nonNull(cur.now.left)){
                maxDepth = Math.max(cur.depth + 1, maxDepth);
                q.add(new Data(cur.now.left, cur.depth + 1));
            }
            if(Objects.nonNull(cur.now.right)){
                maxDepth = Math.max(cur.depth + 1, maxDepth);
                q.add(new Data(cur.now.right, cur.depth + 1));
            }
            maxDepth = Math.max(cur.depth, maxDepth);
        }
        return maxDepth;
    }

    public static class Data {
        public TreeNode now;
        public int depth;

        public Data(TreeNode now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }*/

}
