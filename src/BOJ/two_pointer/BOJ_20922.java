package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int arr[] = new int[N];
        int count[] = new int[100001];
        tk = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        int start = 0;
        int end = 0;
        int ans = 0;
        while(start < N){
            while(end < N && count[arr[end]] < K){
                count[arr[end]]++;
                end++;
            }
            ans = Math.max(end - start,ans);
            count[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}
