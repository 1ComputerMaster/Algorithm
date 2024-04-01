package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());

        int[] dist = new int[N - 1];
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N - 1; i++){
            dist[i] = Integer.parseInt(tk.nextToken());
        }
        int[] arr = new int[N];
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        int min = arr[0];
        long ans = 0;
        for (int i = 0; i < N - 1; i++){
            if(arr[i] >= min){
                ans += (long) dist[i] * min;
            }else{
                min = arr[i];
                ans += (long) dist[i] * min;
            }
        }
        System.out.println(ans);
    }
}
