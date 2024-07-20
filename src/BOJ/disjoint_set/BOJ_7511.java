package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_7511 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(tk.nextToken());

        for (int t = 1; t <= T; t++){
            tk = new StringTokenizer(in.readLine()," ");
            int N = Integer.parseInt(tk.nextToken());
            int[] parent = new int[N];
            for (int i = 0 ; i < N; i++){
                parent[i] = i;
            }
            tk = new StringTokenizer(in.readLine()," ");
            int K = Integer.parseInt(tk.nextToken());

            for(int k = 0; k < K; k++){
                tk = new StringTokenizer(in.readLine()," ");
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());
                union(a,b,parent);
            }
            sb.append("Scenario ").append(t).append(":").append("\n");
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++){
                tk = new StringTokenizer(in.readLine()," ");
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());
                sb.append(find(a,b,parent) + "\n");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b, int[] parent) {
        int rootA = getParent(a,parent);
        int rootB = getParent(b,parent);
        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }

    private static int find(int a, int b, int[] parent) {
        int rootA = getParent(a, parent);
        int rootB = getParent(b, parent);
        if(rootA == rootB){
            return 1;
        }else{
            return 0;
        }
    }

    private static int getParent(int a,int[] parent){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = getParent(parent[a], parent);
        }
    }
}
