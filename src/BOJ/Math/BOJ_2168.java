package BOJ.Math;

import java.util.Scanner;

public class BOJ_2168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int n = GCD(x,y);

        System.out.println(((x / n) + (y / n) - 1) * n);
    }

    private static int GCD(int x, int y) {
        if(y == 0){
            return x;
        }
        return GCD(y, x % y);
    }
}
