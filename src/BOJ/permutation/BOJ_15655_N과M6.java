package BOJ.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655_N과M6 {
	static int num[],visited[];
	static int r;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine()," ");
		visited = new int[N];
		num = new int[N];
		r = M;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(num);
		perm(0,0);
	}
	private static void perm(int i, int j) {
		if(j == r) {
			for (int j2 = 0; j2 < visited.length; j2++) {
				if(visited[j2] == 1) {
					System.out.print(num[j2] + " ");
				}
			}System.out.println();
		}else {
			for (int j2 = i; j2 < visited.length; j2++) {
				if(visited[j2] == 1) {
					continue;
				}else {
					visited[j2] = 1;
					perm(j2,j+1);
					visited[j2] = 0;
				}
			}
		}
	}
}
