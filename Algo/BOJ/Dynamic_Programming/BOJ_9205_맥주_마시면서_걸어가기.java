package Dynamic_Programming;
import java.util.Scanner;
public class BOJ_9205_맥주_마시면서_걸어가기 {
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t<T;t++) {
			int n = sc.nextInt(); //편의점의 갯수
			Data arr[] = new Data[n+2];
			for (int i = 0; i < n+2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new Data(x,y);
			}
			int d[][] = new int[n+2][n+2];
			for(int i = 0;i<n+2;i++) {
				for (int j = 0; j < n+2; j++) {
					if(i != j) {
						int dist = Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y);
						if(dist <= 1000) {
							d[i][j] = 1; // 이때는 갈 수 있구나... 이제부터는 플로이드 마셜 적용
						}else {//못 가는 곳
							d[i][j] = 1000_000_000;
						}
					}
				}
			}
			for (int k = 0; k < d[0].length; k++) {
				for (int i = 0; i < d[0].length; i++) {
					for (int j = 0; j < d[0].length; j++) {
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					}
				}
			}
			//출발지  - 집[0], 도착지 - 락페[마지막]
			if(0<d[0][n+1] && d[0][n+1] < 1000_000_000) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}

}
