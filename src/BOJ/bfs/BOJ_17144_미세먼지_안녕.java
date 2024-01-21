package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕 {
	static int R,C,T;
	static int [][] arr,map;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		T = Integer.parseInt(tk.nextToken());
		arr = new int[R][C];
		map = new int[R][C];
		visited = new boolean[R][C];
		Data air = null;
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				if(arr[i][j] == -1)
				{
					air = new Data(i,j);
				}
			}
		}
		for (int t = 0; t < T; t++) { // T 초 동안 진행
			spread();
			circle(air.x - 1,air.y);
			circle_(air.x, air.y);
		}
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == -1) continue;
				ans+=arr[i][j];
			}
		}
		System.out.println(ans);
		
	}
	private static void circle_(int x, int y) {
        for (int i = x + 1; i < R - 1; i++)
        {
            arr[i][0] = arr[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++)
        {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        for (int i = R - 1; i >= x; i--)
        {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--)
        {
            arr[x][i] = arr[x][i - 1];
        }
        arr[x][1] = 0;
	}
	private static void circle(int x,int y) { //배열 돌리기
		//arr[0][0] ~ arr[x][C-1] //까지 배열 돌리기 문제
		// 1. 공기청정기 위에서부터 (0, 0)까지 모든 값 떙겨주기
        for (int i = x - 1; i > 0; i--)
        {
            arr[i][0] = arr[i - 1][0];
        }
        // 2. 가장 윗줄 땡겨주기
        for (int i = 0; i < C - 1; i++)
        {
            arr[0][i] = arr[0][i + 1];
        }
        // 3. 반대편 세로라인 땡겨주기
        for (int i = 1; i <= x; i++)
        {
            arr[i - 1][C - 1] = arr[i][C - 1];
        }
        // 4. 공기청정기 라인 땡겨주기
        for (int i = C - 1; i > 1; i--)
        {
            arr[x][i] = arr[x][i - 1];
        }
        arr[x][1] = 0;
	}
	private static void copy(int[][]temp,int [][]crr) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				temp[i][j] = crr[i][j];
			}
		}
	}
	private static void spread() {
		copy(map,arr);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] != 0 && arr[i][j] != -1) {
					int cnt = 0;
					int value = (arr[i][j]/5);
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == -1) {
							continue;
						}
						cnt++;
						map[nx][ny] = map[nx][ny] + value;
					}
					map[i][j] -= value*cnt;
				}
			}
		}
		copy(arr,map);
	}
}
