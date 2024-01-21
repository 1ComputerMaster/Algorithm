package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_11727_2n타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d[] = new int[N + 1];
		d[0] = 1;
		d[1] = 1;
		for(int i = 2; i <= N;i++) {
			d[i] = (d[i - 1] + d[i - 2] * 2)%10007;
		}
		
		System.out.println(d[N]%10007);
	}
}
