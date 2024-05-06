package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17123 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(tk.nextToken());

        while (T-- > 0){
            tk = new StringTokenizer(in.readLine()," ");
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());

            int[][] arr = new int[N][N];
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++){
                tk = new StringTokenizer(in.readLine()," ");
                for (int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(tk.nextToken());
                    A[i] += arr[i][j];
                }
            }
            for (int j = 0; j < N; j++){
                for (int i = 0; i < N; i++){
                    B[j] += arr[i][j];
                }
            }
            for (int i = 0; i < M; i++){
                tk = new StringTokenizer(in.readLine()," ");
                int r1 = Integer.parseInt(tk.nextToken()) - 1;
                int c1 = Integer.parseInt(tk.nextToken()) - 1;
                int r2 = Integer.parseInt(tk.nextToken()) - 1;
                int c2 = Integer.parseInt(tk.nextToken()) - 1;
                int v = Integer.parseInt(tk.nextToken());

                for (int j = r1; j <= r2; j++){
                    A[j] += (v *((c2 + 1) - c1));
                }
                for (int j = c1; j <= c2; j++){
                    B[j] += (v*((r2 + 1) - r1));
                }
            }
            for (int i = 0; i < N; i++){
                sb.append(A[i] + " ");
            }
            sb.append("\n");
            for (int i = 0; i < N; i++){
                sb.append(B[i] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
