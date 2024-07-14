package BOJ.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18116_review {
    static class Data{ //부품과 자신의 root_index 값을 저장하는 객체
        int root;
        int part;
        public Data (int root, int part){
            this.root = root;
            this.part = part;
        }
    }
    static Data[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(tk.nextToken());
        //초기화 진행
        parent = new Data[1000001];
        for (int i = 1; i < 1000001; i++){
            parent[i] = new Data(i,1); // 첫 위치는 해당 위치의 부품 1이다.
        }

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine());
            String askChar = tk.nextToken();
            if(askChar.equals("I")){
                int x = Integer.parseInt(tk.nextToken());
                int y = Integer.parseInt(tk.nextToken());
                union(x, y);
            }
            else {
                int a = Integer.parseInt(tk.nextToken());
                System.out.println(parent[find(a)].part);
            }
        }

    }

    private static int find(int a) {
        if(parent[a].root == a){
            return a;
        }
        return parent[a].root = find(parent[a].root);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(parent[rootX].part > parent[rootY].part){
                parent[rootY].root = parent[rootX].root;
                parent[rootX].part += parent[rootY].part;
            }else{
                parent[rootX].root = parent[rootY].root;
                parent[rootY].part += parent[rootX].part;
            }
        }
    }
}
