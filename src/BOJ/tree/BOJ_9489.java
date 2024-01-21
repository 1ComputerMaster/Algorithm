package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9489 {
    static class Node{
        int node;
        int depth;

        boolean parented;
        int parent;
        public Node(int node,int depth, int parent, boolean parented){
            this.node = node;
            this.depth = depth;
            this.parent = parent;
            this.parented = parented;
        }
    }
    static List<Node> tree;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        while (true) {
            tk = new StringTokenizer(in.readLine()," ");
            tree = new ArrayList<Node>();
            int N = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken());
            if (N == 0 && k == 0) {
                break;
            }
            int depth = 0;
            int idx = 0;
            tk = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++){
                int t = Integer.parseInt(tk.nextToken());
                if(i == 1){
                    tree.add(new Node(t,1,tree.get(0).node,false));
                }
                else if(i == 0){
                    tree.add(new Node(t,0,0,true));
                }else{
                    if(isConnected(tree.get(i - 1).node,t)){
                        tree.add(new Node(t,tree.get(i - 1).depth,tree.get(i - 1).parent,false));
                    }else{
                        Node parent = dfs();
                        tree.add(new Node(t,parent.depth + 1,parent.node,false));
                    }
                }
                if(tree.get(i).node == k){
                    depth = tree.get(i).depth;
                    idx = i;
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++){
                if(tree.get(i).depth == depth && tree.get(i).parent != tree.get(idx).parent && siblingDfs(tree.get(i).parent, tree.get(idx).parent)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    private static boolean siblingDfs(int pre_parent,int parent){
        int idx = 0;
        for (int i = 0; i < tree.size(); i++){
            if(tree.get(i).node == parent){
                for (int j = 0; j < tree.size(); j++){
                    if (tree.get(j).node == tree.get(i).parent){
                        idx = j;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < tree.size(); i++){
            if(tree.get(i).node == pre_parent){
                for (int j = 0; j < tree.size(); j++){
                    if (tree.get(j).node == tree.get(i).parent){
                        if(idx == j){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    private static Node dfs() {
        for (int i = 0; i < tree.size(); i++){
            if(!tree.get(i).parented){
                tree.get(i).parented = true;
                return tree.get(i);
            }
        }
        return new Node(-1,-1,-1,false);
    }

    private static boolean isConnected(int preIdx, int idx){
        if(preIdx + 1 == idx){
            return true;
        }else{
            return false;
        }
    }
}
