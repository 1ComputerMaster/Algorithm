package BOJ.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {
    static int[] visited;
    static int[] arr,num;
    static int N,M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        arr = new int[M];
        visited = new int[N];
        num = new int[N];
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0 ; i < N; i++){
            num[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(num);
        backtracking(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void backtracking(int cnt, int start) {
        if(cnt == M){
            for (int i = 0; i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++){
            arr[cnt] = num[i];
            backtracking(cnt + 1, i);
        }
    }
}
