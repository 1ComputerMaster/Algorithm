package BOJ.simulation;

import java.io.*;
import java.util.*;

public class BOJ_10431_줄_세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int ans = 0;
        int arr[];


        for(int i = 0; i < N; i++){
            ans = 0;
            arr = new int[20];
            tk = new StringTokenizer(in.readLine()," ");
            int T = Integer.parseInt(tk.nextToken());
            
            for(int j = 0; j < 20; j++){// 받기
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            for(int j = 1; j < 20; j++){
                for(int k = j-1; k >= 0; k--){
                    if(arr[k] > arr[j]){ // 나 보다 앞에 있는 것 중 나보다 큰 것만 비교한다.
                        ans++;
                    }
                }
            }
            System.out.println(T + " " + ans);
        }
    }
}
