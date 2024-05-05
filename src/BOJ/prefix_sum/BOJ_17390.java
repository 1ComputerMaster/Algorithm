package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17390 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] A = new int[N];
        int[] sum = new int[N + 1];

        tk = new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(A);

        for (int i = 0; i < N; i++){
            sum[i + 1] = sum[i] + A[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int start = Integer.parseInt(tk.nextToken()) - 1;
            int end = Integer.parseInt(tk.nextToken());

            sb.append((sum[end] - sum[start]) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
