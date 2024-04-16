package BOJ.simulation;

import java.util.Scanner;

public class BOJ_20492 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double N = sc.nextDouble();

        System.out.println((int)(N * 0.78) + " " + (int)(((N * 0.2) * 0.78) + (N * 0.8)));
    }
}
