package BOJ.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를_최대로 {
	static int N;
	static int arr[];
	static int temp[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		temp = new int[N];
		visited = new boolean[N];
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken()); //가져옴
		}
		perm(0);
		System.out.println(ans);
	}
	static int ans = 0;
	private static void perm(int n) {
		if(N == n) {
			int sum = 0;
			for (int i = 1; i < N; i++) { //앞에서 가는거 비교
				sum += Math.abs(temp[i] - temp[i-1]);
			}
			ans = Math.max(ans, sum);
			return ;
		}
		else {
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					continue;
				}
				visited[i] = true;
				temp[n] = arr[i];
				perm(n+1);
				visited[i] = false;
			}
		}
	}
}
