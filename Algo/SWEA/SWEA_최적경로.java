import java.util.Arrays;
import java.util.Scanner;


public class SWEA_최적경로 {
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Data[] arr;
	static int sum = 0;
	static int ans = Integer.MAX_VALUE;
	static int N;
	static boolean isSel[];
	static Data[] numbers;
	static int workx;
	static int worky;
	static int housex;
	static int housey;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			workx = sc.nextInt();
			worky = sc.nextInt();
			housex =  sc.nextInt();
			housey = sc.nextInt();
			arr = new Data[N];
			for(int i= 0;i<N;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new Data(x,y);
			}
			isSel = new boolean[N];
			numbers = new Data[N];
			perm(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void perm(int n) {
		if(n == N) {
			sum+=Math.abs(workx - numbers[0].x) + Math.abs(worky - numbers[0].y);
			for(int i = 1;i<n;i++) {
				sum+=Math.abs(numbers[i].x - numbers[i-1].x) + Math.abs(numbers[i].y - numbers[i-1].y);
			}
			sum+=Math.abs(housex - numbers[n-1].x) + Math.abs(housey - numbers[n-1].y);
			ans=Math.min(sum, ans);
			sum = 0;
			return;
		}else {
			for(int i = 0;i<N;i++) {
				if(isSel[i]) continue;
				isSel[i] = true;
				numbers[n] = arr[i];
				perm(n+1);
				isSel[i] = false;
			}
		}
	}
}
