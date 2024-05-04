package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11441 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());

        int[] A = new int[N];
        long[] sum = new long[N + 1];
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
            sum[i + 1] = sum[i] + A[i];
        }

        int M = Integer.parseInt(in.readLine());

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());

            System.out.println(sum[end] - sum[start - 1]);
        }

    }
}
