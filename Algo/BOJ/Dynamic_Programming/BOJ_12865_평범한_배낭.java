package Dynamic_Programming;

import java.util.Scanner;

public class BOJ_12865_평범한_배낭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //물건의 갯수
		int K = sc.nextInt(); //가방의 총 무게
		int d[][] = new int[N+1][K+1];
		int v[] = new int[N+1];
		int w[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			w[i] = sc.nextInt();//믈건의 무게
			v[i] = sc.nextInt();//믈건의 가치
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(w[i] <= j) {
					d[i][j] = Math.max(d[i-1][j],d[i-1][j-w[i]] + v[i]);
				}else {
					d[i][j] = Math.max(d[i-1][j], max);
				}
			}
		}
		System.out.println(d[N][K]);
	}

}
