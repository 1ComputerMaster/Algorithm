package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21317 {
    static int N,K,ans;
    static int[] small,big;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk;

        small = new int[N];

        big = new int[N];
        int initDP[] = new int[N];

        for (int i = 0; i < N - 1; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            small[i] = Integer.parseInt(tk.nextToken());
            big[i] = Integer.parseInt(tk.nextToken());
        }
        K = Integer.parseInt(in.readLine());
        if(N == 1){
            System.out.println(small[0]);
            return;
        }
        initDP[0] = 0;
        initDP[1] = small[0];

        for (int i = 2; i < N; i++)
        {
            initDP[i] = Math.min(initDP[i - 1] + small[i - 1], initDP[i - 2] + big[i - 2]);
        }



        int[] tmpDP = new int[N];
        copyOfArray(initDP,tmpDP);

        ans = Integer.MAX_VALUE;
        for (int i = 3; i < N; i++)
        {
            if (initDP[i - 3] + K < initDP[i]){
                tmpDP[i] = initDP[i - 3] + K;
                ans = Math.min(makeDP(tmpDP),ans);
                copyOfArray(initDP, tmpDP);
            }
        }
        System.out.println(Math.min(ans, initDP[N - 1]));
    }

    private static void copyOfArray(int[] src, int[] des){
        for (int i = 0; i < src.length; i++){
            des[i] = src[i];
        }
    }
    private static int makeDP(int[] tmpDp){
        for (int i = 2; i < N; i++)
        {
            tmpDp[i] = Math.min(Math.min(tmpDp[i - 1] + small[i - 1], tmpDp[i - 2] + big[i - 2]), tmpDp[i]);
        }
        return tmpDp[N - 1];
    }
}
