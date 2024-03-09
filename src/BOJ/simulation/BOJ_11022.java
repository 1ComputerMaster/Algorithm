package BOJ.simulation;

import java.util.Scanner;

public class BOJ_11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println("Case #"+t+": "+ A +" + "+ B + " = " + (A + B));
        }
    }
}
