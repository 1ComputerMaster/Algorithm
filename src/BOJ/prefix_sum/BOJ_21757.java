package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21757 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(tk.nextToken());
        long[] sum = new long[N + 1];
        tk = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
        }
        for (int i = 0; i < N; i++){
            sum[i + 1] = sum[i] + A[i];
        }

        long totalSum = sum[N];
        long zeroCnt = 0;
        long K = sum[N] / 4;
        long[] count = new long[4];
        if(totalSum % 4 != 0){
            System.out.println(0);
        }

        if(totalSum == 0){
            for (int i = 1; i <= N; i++){
                if(sum[i] == 0){
                    zeroCnt++;
                }
            }
            if (zeroCnt >= 4) {
                // nC3 계산: (zeroCnt-1)C3
                long result = (zeroCnt - 1) * (zeroCnt - 2) * (zeroCnt - 3) / 6;
                System.out.println(result);
            } else {
                System.out.println(0);
            }
        } else {
            long ret = 0;
            count[0] = 1;
            for (int i = 1; i <= N; i++) {
                if (sum[i] % K == 0){
                    if(sum[i] / K == 1){
                        count[1] += count[0];
                    }else if(sum[i] / K == 2){
                        count[2] += count[1];
                    } else if (sum[i] / K == 3) {
                        ret += count[2];
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
