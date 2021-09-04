package Dynamic_Programming;

import java.util.Scanner;

public class BOJ_1915_가장_큰_정사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n+1][m+1];
		String str;
		for(int i = 0;i<n;i++) {
			str = sc.next();
			for(int j = 0;j<str.length();j++) {
				arr[i+1][j+1] = str.charAt(j)-'0';
			}
		}
		int max = 0;
		int sum = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i+1][j+1] != 0) {//2일때 가정하고
					int temp = Math.min(arr[i][j],arr[i][j+1]);//둘중 하나라도 0이면 못간다. 그리고 위 왼쪽 대각선 왼쪽 모두 다 같은 값으로 초기화 된다. -> i+1,j+1로 부터 시작하므로
					arr[i+1][j+1] = Math.min(arr[i+1][j], temp)+1; //넘어가니깐 만약 전이 0이면 못가고 temp 위치도 0이면 못가네..
					sum = Math.max(sum, arr[i+1][j+1]);
				}
			}
		}
		System.out.println(sum*sum);
	}
}
