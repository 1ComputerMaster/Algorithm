package BOJ.Math;
import java.util.*;
import java.io.*;
public class BOJ_2581 {
    static int min = Integer.MAX_VALUE;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(in.readLine());
        
        find(M,N);

        if(ans == 0){
            System.out.println(-1);
        }else {
            System.out.println(ans + "\n" + min);
        }
    }

    private static void find(int m, int n) {
        for(int i = m; i <= n; i++){
            boolean checker = check(i);
            if(i == 2 || i == 3){
                min = Math.min(min,i);
            }

            if(checker){
                continue;
            } else {
                min = Math.min(min,i);
                ans += i;
            }
        }
    }

    private static boolean check(int n) {
        if(n == 1){
            return true;
        }

        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return true;
            }
        }
        return false;
    }
}
