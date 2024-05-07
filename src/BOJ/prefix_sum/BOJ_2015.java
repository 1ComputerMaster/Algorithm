package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2015 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        int[] A = new int[N];
        int[] sum = new int[N + 1];

        tk = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
            sum[i + 1] = sum[i] + A[i];
        }

        long ans = 0L;

        map.put(0,1);

        for (int i = 1; i <= N; i++){
            ans += map.getOrDefault(sum[i] - K,0);
            map.put(sum[i],map.getOrDefault(sum[i],0) + 1);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
