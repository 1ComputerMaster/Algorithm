package BOJ.backtracking;

import java.io.*;
import java.util.*;

public class BOJ_14712 {
    static int N;
    static int M,ans;
    static boolean map[][];
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        //반대로 생각하자... -> map[x - 1][y] == true && map[x][y - 1] == true && map[x - 1][y - 1] == true 이 경우만 피하면 되는 것이다..
        map = new boolean[N+1][M+1];

        ans = 0;
        go(0);
        System.out.println(ans);
    }

    private static void go(int idx) {
        if(idx == N*M){
            ans++;
            return;
        }
        else{
            int x = (idx / M) + 1;
            int y = (idx % M) + 1;
            if(map[x - 1][y] == true && map[x][y - 1] == true && map[x - 1][y - 1] == true)
            {
                go(idx+1);
            }else{
                map[x][y] = true;
                go(idx+1);
                map[x][y] = false;
                go(idx+1);
            }
        }
    }

}
