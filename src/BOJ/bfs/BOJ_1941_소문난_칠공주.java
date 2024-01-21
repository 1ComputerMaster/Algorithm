package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Data{
	int x;
	int y;

	Data(int x, int y){
		this.x = x;
		this.y = y;
	}
}
/*
* 구현에서 자꾸 오류나서 블로그 글 보고 따라 친 문제
* 접근은 맞았으나 계속 조합 및 세부적인 조건에서 오류가 났었다.
*/
class BOJ_1941_소문난_칠공주 {
	static String[][] map;
	static boolean[] visited;
	static int ans = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[5][5];
		for(int i=0; i<5; i++){
			String[] temp = br.readLine().split("");
			for(int j=0; j<5; j++){
				map[i][j] = temp[j];
			}
		}
		visited = new boolean[25];
		// 25개중 7개를 선택하는 조합
		comb(0, 7);
		System.out.println(ans);
	}

	private static void comb(int start, int r){
		if(r == 0){
			int num = 0;
			int temp = 0;
			int x = 0;
			int y = 0;
			int[][] map2 = new int[5][5];	// 선택한 자리
			for(int i=0; i<25; i++){
				// row와 column으로 변환
				int row = i/5;
				int col = i % 5;
				if(visited[i]){
					map2[row][col] = 1;	// 자리 선택
					if(temp == 0){
						x = row;
						y = col;
					}

					// 이다솜파 몇명이 선택되었는지 세기
					if(map[row][col].equals("S"))
						num++;
					temp++;	// 7명 모두 골랐다면 빠른 탈출
				}
				if(temp == 7)
					break;
			}
			if(num >= 4){
				bfs(x,y,map2);
			}
			return;
		}
		for(int i=start; i<25; i++){
			if(!visited[i]){
				visited[i] = true;
				comb(i+1, r-1);
				visited[i] = false;
			}
		}
	}
	private static void bfs(int a, int b, int[][] arr){
		Queue<Data> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		q.offer(new Data(a,b));
		visited[a][b] = true;
		int cnt = 1;
		while(!q.isEmpty()){
			Data cur = q.poll();
			for(int i=0; i<4; i++){
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || arr[nx][ny] == 0 || visited[nx][ny]) 
					continue;
				
					q.offer(new Data(nx, ny));
					visited[nx][ny] = true;
					cnt++;
			}
		}
		if(cnt == 7)
			ans++;
	}
}