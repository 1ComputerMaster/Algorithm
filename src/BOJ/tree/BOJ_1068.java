package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static boolean visited[];
    static int root;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        List<Integer>[] nodeList = new ArrayList[N];

        tk = new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < N; i++){
            nodeList[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        root = -1;

        for (int i = 0; i < N; i++){
            int parents = Integer.parseInt(tk.nextToken());
            if (parents == -1){
                root = i;
            }else {
                nodeList[parents].add(i);
            }
        }

        tk = new StringTokenizer(in.readLine()," ");
        int where = Integer.parseInt(tk.nextToken());
        if(where == root){
            System.out.println(0);
        }else {
            visited[where] = true;
            System.out.println(dfs(root, nodeList));
        }
    }

    private static int dfs(int where, List<Integer>[] nodeList) {
        int cnt = 0;
        visited[where] = true;
        for (int i : nodeList[where]){
            if(!visited[i]) {
                visited[i] = true;
                cnt += dfs(i, nodeList);
            }
        }
        if(cnt == 0){
            return 1;
        }else {
            return cnt;
        }
    }
}
