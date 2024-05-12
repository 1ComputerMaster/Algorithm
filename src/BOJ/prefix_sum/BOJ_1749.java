package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++){
            tk = new StringTokenizer(in.readLine());
            for (int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }


        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        int val = sum[i][j] - sum[k - 1][j] - sum[i][l - 1] + sum[k - 1][l - 1];
                        ans = Math.max(ans,val);
                    }
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
