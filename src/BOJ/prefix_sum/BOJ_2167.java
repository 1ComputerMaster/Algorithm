package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++)
        {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        int K = Integer.parseInt(in.readLine());
        while(K-- > 0){
            tk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());
            int sum = 0;
            for (int i = a - 1; i < c; i++){
                for (int j = b - 1; j < d; j++){
                    sum += arr[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
