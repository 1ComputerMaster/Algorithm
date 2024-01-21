package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    static int N,M;
    static int num[];
    static int arr[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        num = new int[N];
        arr = new int[M];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(num);
        go(0,0);
        System.out.println(sb.toString());
    }

    private static void go(int idx,int start) {
        if(idx == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < N; i++){
           arr[idx] = num[i];
           go(idx+1,i);
        }
    }
}
