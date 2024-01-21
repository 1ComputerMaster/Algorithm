package BOJ.simulation;

import java.util.Scanner;

public class BOJ_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		x = Math.min(Math.abs(0-x), Math.abs(w-x));
		y = Math.min(Math.abs(0-y), Math.abs(h-y));
		x = Math.min(x, y);
		System.out.println(x);
	}

}
