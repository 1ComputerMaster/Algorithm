package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1188 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        while(M <= N){
            N -= M;
        }
        if(M == 0){
            System.out.println(0);
        }else {
            int down = (M / GCD(M,N));
            System.out.println(down);
        }

    }
    private static int GCD (int a, int b){
        if (b == 0){
            return a;
        }
        return GCD(b,a%b);
    }

}
