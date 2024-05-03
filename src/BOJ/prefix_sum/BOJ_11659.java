package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int arr[] = new int[N];
        int sum[] = new int[N + 1];
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(tk.nextToken()) - 1;
            int end = Integer.parseInt(tk.nextToken());
            System.out.println(sum[end] - sum[start]);
        }
    }
}
