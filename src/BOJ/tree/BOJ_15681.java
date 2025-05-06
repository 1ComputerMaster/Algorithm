package BOJ.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15681 {
    static class Tree{
        final List<Integer> subTree = new ArrayList<>();
        int subTreeSize = -1;

        public Tree() {
        }
    }
    static Tree[] trees;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();
        trees = new Tree[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++){
            trees[i] = new Tree();
        }
        for (int i = 0; i < N - 1; i++) {
            int U = sc.nextInt();
            int V = sc.nextInt();
            trees[U].subTree.add(V);
            trees[V].subTree.add(U);
        }
        getSubTrees(R);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = sc.nextInt();
            result.append(trees[U].subTreeSize).append("\n");
        }

        // 결과 출력
        System.out.print(result);
    }

    private static int getSubTrees(int node) {
        visited[node] = true;
        int ans = 1;
        for(int child : trees[node].subTree){
            if(!visited[child])
            {
                ans += getSubTrees(child);

            }
        }
        trees[node].subTreeSize = ans;
        return ans;
    }
}
