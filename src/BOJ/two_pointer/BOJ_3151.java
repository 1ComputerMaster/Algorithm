package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3151 {
    static int arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        arr = new int[N];

        tk = new StringTokenizer(in.readLine()," ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr);

        long cnt = 0;

        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                int sum = arr[i] + arr[j]; // 10000 * 10000 * 5
                int l = j + 1;
                int r = N;
                int left = lower_bound(l,r,sum);
                int right = upper_bound(l,r,sum);
                cnt += right - left;
            }
        }
        System.out.println(cnt);
    }

    private static int lower_bound(int l, int r, int sum) {
        while(l < r){
            int mid = (l + r) / 2;
            if(sum + arr[mid] >= 0){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private static int upper_bound(int l, int r, int sum) {
        while(l < r){
            int mid = (l + r) / 2;
            if(sum + arr[mid] > 0){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
