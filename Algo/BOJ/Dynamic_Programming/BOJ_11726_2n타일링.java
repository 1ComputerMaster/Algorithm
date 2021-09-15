package Dynamic_Programming;

import java.util.Scanner;

public class BOJ_11726_2n타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d[] = new int[N + 1];
		d[0] = 1;
		d[1] = 2;
		for(int i = 2; i <= N;i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		System.out.println(d[N-1]%10007);
	}

}
