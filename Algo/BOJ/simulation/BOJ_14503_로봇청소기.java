package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
			arr[r][c] = 2; //아하 여기서 초기화 하자
			ans++;
		}
		boolean check = false;
		int origin = d;
		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nx = r + dx[nd];
			int ny = c + dy[nd];
			if (nx > 0 && ny > 0 && nx < N && ny < M) {
				if (arr[nx][ny] == 0) { //처음 닫는 공간
					clean(nx, ny, nd); // 다시 치우고
					check = true; //여기가 true가 안 된다면 밑에선 한 번도 못간 공간이 된다.
					break;
				}
			}
			d = (d + 3) % 4;
		}
		if (!check) { // 4 방향 모두 청소가 되었거나 또는 벽인 경우이다
			int temp = (origin + 2)%4;
			int nx = r + dx[temp];
			int ny = c + dy[temp];
			if (nx > 0 && ny > 0 && nx < N && ny < M) {
				if (arr[nx][ny] != 1) { //뒤가 벽이 아니면...
					clean(nx, ny, origin); // 바라보는 방향 유지한 채 후진
				}
			}
		}
	}
}