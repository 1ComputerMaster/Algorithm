package BOJ.backtracking;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static int N;
    static int arr[];
    static int ans;
    static int S;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());

        S = Integer.parseInt(tk.nextToken());

        arr = new int[N];

        ans = 0;

        tk = new StringTokenizer(in.readLine()," ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        if(S == 0){
            ans--;
        }

        go(0,0);

        System.out.println(ans);

    }
    private static void go(int idx,int sum) {
        if(idx == N){
            if(sum == S){
                ans++;
                return;
            }
            return;
        }
        go(idx+1,sum);

        go(idx+1,sum + arr[idx]);
    }
}
