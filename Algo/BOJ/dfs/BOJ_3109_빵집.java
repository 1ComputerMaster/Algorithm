package dfs;

import java.util.Scanner;

/*
 * 빵집 운영
 * 
 * 빵집이 있는 곳은 R*C 격자로 표현 가능하다.
 * 첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집이다.
 * 가스관과 빵집을 연결하는 파이프를 설치하려고 한다.
 * 
 * 
 * 
 * 
 */
public class BOJ_3109_빵집 {

	
	private static int[] dx = {-1,0,1};
	static int r;
	static int c;
	static boolean check[][];
	static char arr[][];
	static int cnt = 0;
	static boolean isConnected = false; //가지치기용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new char[r][c];
		check = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = sc.next().toCharArray();
		} 
		for(int i = 0;i<r;i++)
		{
			isConnected = false;
			dfs(i,0);
		}
		System.out.println(cnt);
	}

	private static void dfs(int x, int y) {
		if(isConnected == true) { //끝에서 갔던데서 또 가니깐 그것을 막는 것이였다... 어렵게 생각하지 말자 가지치기 할 뿐...
			return;
		}
		if(y == c-1) {
			isConnected = true; //가지치기
			cnt++;
			return;
		}
		check[x][y] = true;
		for (int i = 0; i < 3; i++) {
			int nx = x+dx[i];
			int ny = y+1;
			if(nx < 0 || nx >=r || ny >= c || ny < 0 || check[nx][ny] == true || arr[nx][ny] == 'x') continue;
			dfs(nx,ny);
		}
	}
}
