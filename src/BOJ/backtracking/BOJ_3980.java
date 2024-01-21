package BOJ.backtracking;
import java.util.*;
import java.io.*;

public class BOJ_3980 {
    static int T;
    static int arr[][];
    static boolean visited[];
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            ans = 0;
            StringTokenizer tk;
            arr = new int[11][11];
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                tk = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(tk.nextToken());
                }
            }
            go(0, 0);
            System.out.println(ans);
        }
    }

    private static void go(int idx,int sum) {
        if(idx == 11){
            ans = Math.max(sum,ans);
        }
        for(int i = 0; i < 11; i++){
            if(!visited[i] && arr[idx][i] != 0) {
                visited[i] = true;
                go(idx + 1,sum + arr[idx][i]);
                visited[i] = false;
            }
        }
    }
}