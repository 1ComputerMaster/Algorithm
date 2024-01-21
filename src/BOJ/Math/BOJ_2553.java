package BOJ.Math;

import java.util.Scanner;

public class BOJ_2553 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long num = 1;
        for (int i = 1; i <= N; i++){
            num *= i;
            num %= 10000000000L;
            while(num % 10 == 0){
                num /= 10;
            }
        }
        System.out.println(num%10);
    }
}
