package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10775 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int G = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");

        int P = Integer.parseInt(tk.nextToken());
        parent = new int[G + 1];
        for (int i = 1; i < G + 1; i++){
            parent[i] = i;
        }
        for (int i = 0; i < P; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int gate = Integer.parseInt(tk.nextToken());
            gate = find(gate);
            if(gate == 0){
                System.out.println(i);
                return;
            }
            union(gate - 1, gate);
        }
        System.out.println(P);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootB] = rootA;
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
