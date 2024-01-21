package BOJ.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 섬의 갯수
 */
public class BOJ_4963 {
static class Data{
	int x;
	int y;
	public Data(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향
static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int w = sc.nextInt();
			int h = sc.nextInt();
			boolean check[][] = new boolean[h][w];
			if(w == 0 && h == 0)
			{
				return;
			}
			ArrayList<Data> land = new ArrayList();
			
			int arr[][] = new int[h][w];
			for(int i = 0;i<h;i++) {
				for(int j = 0; j<w;j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) {
						land.add(new Data(i,j));
					}
				}
			}
			int cnt = land.size() -1; //8
			int land_cnt = 0;
			Queue<Data> q = new LinkedList<Data>();
			while(cnt >= 0)// 
			{
				if(arr[land.get(cnt).x][land.get(cnt).y] == 1) //
				{
					q.add(land.get(cnt));
					check[land.get(cnt).x][land.get(cnt).y] = true;
					land_cnt++;
					while(!q.isEmpty())
					{
						int x = q.peek().x;
						int y = q.peek().y;
						q.poll();
						for(int k = 0; k<8;k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx < 0 || ny < 0 || nx >= h || ny >= w || arr[nx][ny] == 0 || check[nx][ny] == true) {
								continue;
							}
							check[nx][ny] = true;
							arr[nx][ny] = 0; //0이면 못 감
							q.add(new Data(nx,ny));
						}
					}
				}
				cnt--;
			}
			System.out.println(land_cnt);
		}
	}
}
