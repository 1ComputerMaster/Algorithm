package BOJ.Dynamic_Programming;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        BigInteger sum = new BigInteger("1");
        BigInteger div = new BigInteger("1");

        for(int i = 0; i < M; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(N-i))); //이미 (N-M)! 전까지 수행해서 약수처리 되었다.
            div = div.multiply(new BigInteger(String.valueOf(i+1)));
        }
        System.out.println(sum.divide(div));
    }
}
