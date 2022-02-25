package simulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1026_보물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer a[] = new Integer[n];
		Integer b[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int ans = 0;
		Arrays.sort(a);
		Arrays.sort(b, (a2, a1) -> a1 - a2);
		for (int i = 0; i < n; i++) {
			ans += a[i] * b[i];
		}
		System.out.println(ans);
	}

}
