package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1507 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        int map[][] = new int[N][N];
        boolean check[][] = new boolean[N][N];

        for (boolean tmp[] : check){
            Arrays.fill(tmp, true);
        }
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        for (int k = 0; k < N; k ++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    if(map[i][j] > map[i][k] + map[k][j]){
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][j] == map[i][k] + map[k][j])
                        check[i][j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(check[i][j]){
                    ans += map[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}