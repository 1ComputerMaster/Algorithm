package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22862 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int arr[] = new int[N];
        tk = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        int start = 0;
        int end = 0;
        int ans = 0;
        int cnt = 0;
        while(end < N){
            while(end < N) {
                if (arr[end] % 2 == 0) {
                    end++;
                } else {
                    if (cnt < K) {
                        cnt++;
                        end++;
                    } else {
                        break;
                    }
                }
            }
            ans = Math.max(ans,end - start - cnt);
            while(start < N){
                if(arr[start] % 2 != 0) {
                    cnt--;
                    start++;
                    break;
                }else {
                    start++;
                }
            }
        }
        System.out.println(ans);
    }
}
