package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int arr[][];
	static int N, M;
	static int dx[] = { -1, 0, 1, 0 }; // 북,동,남,서 public
	static int dy[] = { 0, 1, 0, -1 };
	static int ans = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new int[N][M];
		tk = new StringTokenizer(in.readLine()," ");
		int r = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		int d = Integer.parseInt(tk.nextToken());
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
		clean(r,c,d);
		System.out.println(ans);
	}

	private static void clean(int r, int c, int d) {
		if(arr[r][c] == 0) {
			arr[r][c] = 2;
			ans++;
		}
		int origin = d;
		boolean check = true;
		for (int i = 0; i < 4; i++) {
			d = (d+3)%4;
			int nx = r + dx[d];
			int ny = c + dy[d];
			if(nx >= 0 && ny >= 0 && nx < N && ny < M)
			{
				if(arr[nx][ny] == 0)
				{
					clean(nx,ny,d);
					check = false;
					break;
				}
			}
		}
		if(check) {
			int temp = (origin + 2)%4;
			int nx = r + dx[temp];
			int ny = c + dy[temp];
			if(arr[nx][ny] != 1) {
				clean(nx,ny,origin);
			}
		}
	}
}