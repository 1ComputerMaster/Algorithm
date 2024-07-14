package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1976 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        int[] parent = new int[N + 1];

        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int M = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int size = tk.countTokens();
            for (int j = 0; j < size; j++){
                if(Integer.parseInt(tk.nextToken()) == 1){
                    union(i + 1, j + 1,parent);
                }
            }
        }

        tk = new StringTokenizer(in.readLine(), " ");
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(tk.nextToken());
        }

        boolean possible = true;
        int root = getParent(parent, plan[0]);
        for (int i = 1; i < M; i++) {
            if (getParent(parent, plan[i]) != root) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    private static int getParent(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void union(int x, int y, int[] parent) {
        int rootA = getParent(parent,x);
        int rootB = getParent(parent,y);
        parent[rootB] = rootA;
    }
}
