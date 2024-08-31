package BOJ.Dynamic_Programming;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        BigInteger[][] bigIntegers = new BigInteger[101][101];

        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                bigIntegers[i][j] = new BigInteger("0");
            }
        }

        for (int i = 0; i < 101; i++){
            bigIntegers[i][i] = new BigInteger("1");
            bigIntegers[i][1] = new BigInteger(String.valueOf(i));
        }
        for (int i = 3; i < 101; i++){
            for (int j = 1; j < i; j++){
                if(bigIntegers[i][j].equals(new BigInteger("0")))
                {
                    bigIntegers[i][j] = bigIntegers[i - 1][j].add(bigIntegers[i - 1][j - 1]);
                }
            }
        }
        System.out.printf(String.valueOf(bigIntegers[N][M]));
    }
}
