package BOJ.tree;

import java.util.*;

public class BOJ_11725 {

    static int result[];
    static boolean visited[];
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        result = new int[N+1];
        for (int i = 0; i < N-1; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        visited = new boolean[N+1];
        bfs(1);
        for (int i = 2; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>(list[start]);
        for (int i = 0; i < list[start].size(); i++){
            result[list[start].get(i)] = start;
        }
        while(!q.isEmpty()){
            int parents = q.poll();
            for (int i = 0; i < list[parents].size(); i++){
                if(!visited[list[parents].get(i)]) {
                    visited[list[parents].get(i)] = true;
                    if(result[list[parents].get(i)] == 0) {
                        result[list[parents].get(i)] = parents;
                    }
                    q.add(list[parents].get(i));
                }
            }
        }
    }
}
