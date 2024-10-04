package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2167_re {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str[] = in.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int arr[][] = new int[N][M];
        for (int i = 0; i < N; i++){
            str = in.readLine().split(" ");
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int K = Integer.parseInt(in.readLine());

        while (K-- > 0){
            str = in.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;
            int c = Integer.parseInt(str[2]) - 1;
            int d = Integer.parseInt(str[3]) - 1;
            int sum = 0;

            for (int i = a; i <= c; i++){
                for (int j = b; j <= d; j++){
                    sum += arr[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
