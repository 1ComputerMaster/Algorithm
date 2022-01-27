package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656_N과M7 {
	static int[] arr;
	static int M,N;
	static int visited[],count[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine()," ");
		arr = new int[N];
		visited = new int[N];
		count = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb.toString());
	}
	private static void dfs(int start) {
		if(start == M) {
			for (int i = 0; i < visited.length; i++) {
				if(visited[i] > 0) {
					sb.append(visited[i] + " ");
				}
			}sb.append("\n");
		}
		else {
			for (int j2 = 0; j2 < N; j2++) {
				visited[start] = arr[j2]; //모든 것을 다 뽑는 경우의 수
				dfs(start + 1); // 바로 다음 것 다시 뽑고
			}
		}
	}
}
