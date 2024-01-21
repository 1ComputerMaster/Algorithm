package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int arr[] = new int[N];
        int arr1[] = new int[M];
        tk = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < M; i++){

            arr1[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(arr1);


        int right = 0;
        int left = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        while(right < N && left < M){
            if(arr[right] < arr1[left]){
               sb.append(arr[right++] + " ");
            }
            else{
                sb.append(arr1[left++] + " ");
            }
        }

        while(right < N){
            sb.append(arr[right++] + " ");
        }
        while(left < M){
            sb.append(arr1[left++] + " ");
        }

        System.out.println(sb);
    }
}
