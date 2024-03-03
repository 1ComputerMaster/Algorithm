package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N];

        int[] plusDp = new int[N];
        int[] sumDp = new int[N];

        tk = new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        int ans = 1;
        plusDp[0] = 1;

        for (int i = 1; i < N; i++){
            if(arr[i - 1] >= arr[i]){
                plusDp[i] = plusDp[i - 1] + 1;
            }else{
                plusDp[i] = 1;
            }
            ans = Math.max(ans,plusDp[i]);
        }
        sumDp[0] = 1;
        for (int i = 1; i < N; i++){
            if(arr[i - 1] <= arr[i]){
                sumDp[i] = sumDp[i - 1] + 1;
            }else{
                sumDp[i] = 1;
            }
            ans = Math.max(ans,sumDp[i]);
        }
        System.out.println(ans);
    }
}
