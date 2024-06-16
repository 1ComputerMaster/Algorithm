package BOJ.Divide;

import java.util.Scanner;

public class BOJ_1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int result = zOrder(N, r, c);
        System.out.println(result);
    }

    private static int zOrder(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1); // 2 ^ (n - 1)
        int quadrantSize = half * half;

        if (r < half && c < half) {
            // 1st quadrant (top-left)
            return zOrder(n - 1, r, c);
        } else if (r < half && c >= half) {
            // 2nd quadrant (top-right)
            return quadrantSize + zOrder(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            // 3rd quadrant (bottom-left)
            return 2 * quadrantSize + zOrder(n - 1, r - half, c);
        } else {
            // 4th quadrant (bottom-right)
            return 3 * quadrantSize + zOrder(n - 1, r - half, c - half);
        }
    }
}