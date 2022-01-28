package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 중복 조합
 * */
public class BOJ_15657_N과M8 {
	static int arr[],visited[];
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new int[N];
		visited = new int[N];
		tk = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);
	}
	private static void comb(int start,int r) {
		if(r == M) {
			for (int i = 0; i < N; i++) {
				if(visited[i] != 0) {
					System.out.print(visited[i] + " ");
				}
			}System.out.println();
		}else {
			for (int i = start; i < N; i++) {
				visited[r] = arr[i];
				comb(i,r+1);
			}
		}
	}
}
