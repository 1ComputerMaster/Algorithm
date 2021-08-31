package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 달이 차오른다, 가자!
 */
public class BOJ_1194 {
	static class Data{
		int x;
		int y;
		char z;
		public Data(int x, int y,char z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int temp = 0;
	static int ans = 0;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String str;
		Data start = new Data(0,0,'0');
		int dist[][] = new int[N][M];
		char crr[][] = new char[N][M];
		ArrayList<Data> key = new ArrayList<Data>(); //키 배열
		int cnt = 0;
		for(int i = 0;i<N;i++) {
			str = sc.next();
			for(int j = 0; j<M;j++) {
				crr[i][j] = str.charAt(j);
				if(crr[i][j]=='0') {
					start = new Data(i,j,crr[i][j]);
				}				
				for(int k = 0;k<6;k++)
				{
					if(crr[i][j] == 'a'+k) {
						key.add(new Data(i,j,(char)('a'+k)));
					}
				}
			}
		}
		Queue<Data> q = new LinkedList<Data>(); 
		Data door = null;
		//문 무시하고 돌기 후
		//문 거쳤다는것은 기록
		
		q.add(start);
		dist[start.x][start.y] = 1;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			System.out.println(x+" "+y);
			for(int i = 0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx < 0 || nx>=N || ny <0 || ny >= M || crr[nx][ny] == '#') {
					continue;
				}
				for(int k = 0;k<6;k++)
				{
					if(crr[nx][ny] =='A'+k) {
						door = new Data(nx,ny,crr[nx][ny]);
					}
				}
				if(crr[nx][ny] =='1') {
					//도착
					ans += dist[nx][ny] = dist[x][y]+1;
					break;
				}else {
					dist[nx][ny] = dist[x][y] + 1;
					q.add(new Data(nx,ny,crr[nx][ny]));
				}
			}
		}
		if(door != null) {
			ans = 0;
			if(key.contains(door.z)) {//키가 있으면 이 키의 위치를 거쳐서 탐색하는 bfs를 작성해야한다.
				q.add(start);
				dist[start.x][start.y] = 1;
				q = new LinkedList<Data>();
				while(!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.peek().y;
					q.poll();
					for(int i = 0;i<4;i++)
					{
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx < 0 || nx>=N || ny <0 || ny >= M || crr[nx][ny] == '#') {
							continue;
						}
						if(crr[nx][ny] == door.z) {
							//도착
							dist[nx][ny] = dist[x][y]+1;
							break;
						}else {
							dist[nx][ny] = dist[x][y] + 1;
							q.add(new Data(nx,ny,crr[nx][ny]));
						}
					}
				}
				q.add(start);
				while(!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.peek().y;
					q.poll();
					for(int i = 0;i<4;i++)
					{
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx < 0 || nx>=N || ny <0 || ny >= M || crr[nx][ny] == '#') {
							continue;
						}
						if(crr[nx][ny] == '1') {
							//도착
							ans+=dist[nx][ny] = dist[x][y]+1;
							break;
						}else {
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Data(nx,ny,crr[nx][ny]));
						}
					}
				}
			}
			//문 피해서 bfs 돌리기
			
			q.add(start);
			dist[start.x][start.y] = 1;
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				q.poll();
				for(int i = 0;i<4;i++)
				{
					int nx = x+dx[i];
					int ny = y+dy[i];
					for(int i1 = 0;i1<6;i1++)
					{
						if(nx < 0 || nx>=N || ny <0 || ny >= M || crr[nx][ny] == '#' || crr[nx][ny] =='A'+i1) {
						continue;
						}
					}
					if(crr[nx][ny] == '1') {
						//도착
						temp += dist[nx][ny] = dist[x][y]+1;
						break;
					}else {
					dist[nx][ny] = dist[x][y] + 1;
					q.add(new Data(nx,ny,crr[nx][ny]));
					}
				}
			}
			if(temp > ans) {
				System.out.println(ans);
			}
			System.out.println(temp);
			
			
		}else {
			System.out.println(ans);
		}
		//그냥 문 피해서 bfs 돌리기
		
		
	}

}
