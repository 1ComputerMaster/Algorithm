package BOJ.Math;

import java.util.Scanner;

public class BOJ_1110 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N < 10){
            N*=10;
        }
        int n = N;
        int cnt = 0;
        while (true){
            int first = n / 10;
            int second = n % 10;

            int tmp = (first + second) % 10;

            n = second*10 + tmp;

            cnt++;

            if(n == N){
                break;
            }
        }
        System.out.println(cnt);
    }
}
