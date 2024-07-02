package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int parent[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < m; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int k = Integer.parseInt(tk.nextToken());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            if(k == 0) {
                if(!find(parent,a,b)) {
                    union(parent,a,b);
                }
            }else {
                if(!find(parent,a,b)) {
                    System.out.println("NO");
                }else {
                    System.out.println("YES");
                }
            }
        }

    }

    private static void union(int[] parant, int a, int b){
        int rootA = getParent(parant,a);
        int rootB = getParent(parant,b);
        if(rootA != rootB){
            parant[rootB] = rootA;
        }
    }

    private static int getParent(int[] parant, int x) {
        if(parant[x] == x){
            return x;
        }else {
            return parant[x] = getParent(parant, parant[x]);
        }
    }

    public static boolean find(int[] parent,int a,int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }
}
