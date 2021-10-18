package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//얼음은 동시에 녹는다!!!!
public class BOJ_2573_빙산 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int arr[][];
	static int N,M;
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
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		for (int cnt = 0; cnt < 1000 ; cnt++) { //300*300 -> 10회 이상씩 돌면 / 대강 800회
			visited = new boolean[N][M];
			int check = 0; // 두 개 이상의 빙산으로 나뉘는지 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] != 0 && visited[i][j] == false) {
						find(i,j);//여기서 돈다
						check+=1;
					}
					if(check > 1) {
						System.out.println(cnt);
						return;
					}
				}
			}
			if(check == 0) { //일단 두개 이상으로 나누어지면 바로 0 출력
				System.out.println(0);
				return;
			}
			visited = new boolean[N][M]; //다시 초기화
			int temp[][] = new int[N][M]; //동시에 녹지 않는다면 먼저 녹은 것에 의하여 더 녹는것이 생긴다.
			check(0,0); //사각형의 가장자리 부분만 먼저 없어져야 하므로 체크
			for (int i = 0; i < N; i++) { //이곳은 빙산 내부에서 0자리와 만나서 없어지는 부분을 찾기 위함이다..
				for (int j = 0; j < M; j++) {
					if(arr[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(nx < 0 || ny < 0 || ny >= M || nx >= N || arr[nx][ny] != 0) {
								continue;
							}
							if(arr[nx][ny] == 0) {
								visited[i][j] = true;
							}
						}

					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] != 0 && visited[i][j]) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(nx < 0 || ny < 0 || ny >= M || nx >= N || arr[nx][ny] != 0) {
								continue;
							}
							if(arr[nx][ny] == 0) {
								temp[i][j]+=1; //사라지는 빙산을 체크하기 위한 배열 동시에 사라지므로 하나가 먼저 사라지고 다시 체크하면 더 많이 줄어드는 빙산이 생긴다
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(temp[i][j] != 0 && arr[i][j] > 0) {
						arr[i][j] -= temp[i][j]; //나중에 추후 빼면서 체크한다.
						if(arr[i][j] < 0) {
							arr[i][j] = 0;
						}
					}
				}
			}
		}
	}
	
	private static void check(int i, int j) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(i,j));
		visited[i][j] = true;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(nx < 0 || ny < 0 || ny >= M || nx >= N || visited[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] != 0) {
					visited[nx][ny] = true;
					continue;
				}
				q.add(new Data(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}

	private static void find(int i, int j) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(i,j));
		visited[i][j] = true;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(nx < 0 || ny < 0 || ny >= M || nx >= N || visited[nx][ny] || arr[nx][ny] == 0) {
					continue;
				}
				q.add(new Data(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
}
