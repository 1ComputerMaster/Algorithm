package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_거리두기_확인_미완 {
    static int[] dy = { -1,1,0,0}; // 좌상부터 시계방향
    static int[] dx = { 0,0,1,-1};
    static class Data{
    	int x;
    	int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
	private static boolean[][] visited;
	private static char arr[][];
    public static int[] solution(String[][] places) {
        int[] answer = {-1,-1,-1,-1,-1};
        arr = new char[5][5];
        int cnt = -1;
    	for (int i = 0; i < places.length; i++) { //row
    		for (int j = 0; j < places[0].length; j++) { //col
				arr[j] = places[i][j].toCharArray();
				if(j == 4) {
					cnt++;
					loop : for (int k = 0; k < arr.length; k++) {
						for (int k2 = 0; k2 < arr[0].length; k2++) {
							if(arr[k][k2] == 'P') {
								visited = new boolean[5][5];
								check = true;
								Data d = bfs(k,k2);
								if(d == null) {
									answer[cnt] = 1;
									continue;
								}
								else {
									int temp = Math.abs(k-d.x) + Math.abs(k2-d.y);
									if(temp <= 2) {
										answer[cnt] = 0;
										break loop;
									}else {
										if(answer[cnt] == -1 || answer[cnt] == 1) {
											answer[cnt] = 1;
											continue;
										}
									}
								}
							}
							if(answer[cnt] == -1) {
								answer[cnt] = 1;
							}
						}
					}
				}
			}
		}
        return answer;
    }
    private static boolean check = true;
	private static Data bfs(int x, int y) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx < 0 || nx >= 5 || ny >= 5 || ny < 0 || visited[nx][ny] || arr[nx][ny] =='X') continue;
				if(arr[nx][ny] == 'P') {
					return new Data(nx,ny);
				}
				q.add(new Data(nx,ny));
				visited[nx][ny] = true;
			}
		}
		return null;
	}
}
