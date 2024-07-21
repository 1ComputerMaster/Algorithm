package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static int N,M;
    static StringBuilder sb;
    static int[] arr, visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        arr = new int[M];
        visited = new int[N];
        backtracking(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void backtracking(int cnt, int start) {
        if(cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++){
            arr[cnt] = i + 1;
            backtracking(cnt + 1, i);
        }
    }
}
