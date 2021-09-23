package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 감이 안 잡혀서 블로그 글을 보고 푼 문제입니다.
 * 
 * 
 * 
 */

public class Jungol_1681_해밀턴_순환회로 {
	static int N;
	static boolean visited[];
	static int ans = 0;
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		StringTokenizer tk;
		for (int i = 0; i < arr.length; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		visited[0] = true; // 출발점
		ans = Integer.MAX_VALUE;
		perm(0,1,0);
		System.out.println(ans);
		
	}
	private static void perm(int cur, int depth, int sum) {
		// TODO Auto-generated method stub
		if(depth == N) {
			if(arr[cur][0] == 0) { //다시 출발지로 돌아 갈 수 없다면 리턴
				return;
			}
			sum+=arr[cur][0];//리턴하는 거 들어감
			ans = Math.min(ans, sum);// 어짜피 최소값이 되어야 하므로
			return;
		}
		for (int i = 1; i < N; i++) {
			if(visited[i] == false && arr[cur][i] != 0 && sum + arr[cur][i] < ans) {
				visited[i] = true;//선택
				perm(i, depth + 1, sum + arr[cur][i]);
				visited[i] = false;
			}
		}
	}
}
