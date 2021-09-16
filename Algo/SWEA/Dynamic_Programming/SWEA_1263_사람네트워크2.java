package Dynamic_Programming;

import java.util.Scanner;

public class SWEA_1263_사람네트워크2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for(int i = 0;i < N;i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if(i != j && arr[i][j] == 0) {
						arr[i][j] = 100_000_000;
					}
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(k == i) continue; // 출발지랑 도착지가 같은 경우는 해 볼 필요가 없다.
					for (int j = 0; j < N; j++) {
						if(i == j || j == k) continue; // 도착지랑 출발지가 같은 경우도 해볼 필요가 없다.
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]); 
						//위에 도착지랑 출발지가 같은 경우들을 체크 하지 않으면
						//음수 값들이 들어와서 초기화 되어 버린다.
					}
				}
			}
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += arr[i][j];
					if(j == N-1) {
						if(min > sum) {
							min = sum;
						}
						sum = 0;
					}
				}
			}
			System.out.println("#"+t+" "+min);
		}
	}
}
