package BOJ.Math;

import java.util.Scanner;

public class BOJ_21920 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int A[] = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        int X = sc.nextInt();
        double ans = 0;
        double cnt = 0;

        for(int i = 0; i < N; i++) {
            if (GCD(A[i], X) == 1) {
                ans += A[i];
                cnt++;
            }
        }
        System.out.println(ans/cnt);
    }

    private static int GCD(int a, int b) {
        if(b == 0){
            return a;
        }else {
            return GCD(b, a % b);
        }
    }

}
