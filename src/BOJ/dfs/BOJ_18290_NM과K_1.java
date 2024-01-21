package BOJ.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290_NM과K_1 {
	static int N,M,K;
	static int arr[][],visited[][];
	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { 1,-1,0,0 };
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken()); //최대 선택
		ans = -99999999;
		arr = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(ans);
	}
	private static boolean check(int x,int y) {
	    for (int i = 0;i < 4;++i) {
		    int nx = x + dx[i];
		    int ny = y + dy[i];
		    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
		    	if (visited[nx][ny] == 1) {
		    		return false;
		    	}
		    }
	    }
	return true;
		
	}
	private static void dfs(int sum,int cnt) {
		if(cnt == K) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check(i,j) == true && visited[i][j] == 0) {
				    visited[i][j] = 1;
				    dfs(sum + arr[i][j], cnt + 1);
				    visited[i][j] = 0;
                }
			}
		}
	}

}
