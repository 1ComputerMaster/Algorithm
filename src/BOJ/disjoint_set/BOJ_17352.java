package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17352 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            union(a,b);
        }
        findRoot();
    }

    private static void findRoot() {
        int cnt = 0;
        for (int i = 1; i < parent.length; i++){
            if(parent[i] == i){
                cnt++;
                System.out.print(i + " ");
                if(cnt >= 2){
                    break;
                }
            }
        }
    }

    private static int getParent(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = getParent(parent[a]);
        }
    }
    private static void union(int a, int b) {
        int rootA = getParent(a);
        int rootB = getParent(b);
        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }
}
