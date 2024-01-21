package BOJ.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_15686_chicken_G5 {
	static int M;
	static int N;
	static boolean isSel[] = new boolean[14];
	static Data numbers[];
	static ArrayList<Data> chicken;
	static int arr[][];
	static LinkedList<Data> home;
	static int ans = 0;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int dist[][];
	static int min = Integer.MAX_VALUE;
	static LinkedList<Data>temp;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		chicken = new ArrayList<Data>(); 
		home = new LinkedList<Data>();
		temp = new LinkedList<>();
		arr = new int[N][N];
		numbers = new Data[M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2)
				{
					chicken.add(new Data(i,j));
					arr[i][j] = 0;
				}
				if(arr[i][j] == 1) {
					home.add(new Data(i,j));
				}
			}
		}
		temp = home;
		comb(0,0);

		
		System.out.println(min);
	}
	private static void comb(int n,int start) {
		if(n == M) { // 폐업 안 시킬것들 나옴
			ans = 0;
			//조합으로 선정 된 거 나오고
			for(int i = 0;i<N;i++)
			{
				for(int j = 0;j<N;j++)
				{
					if(arr[i][j]==2) {
						arr[i][j] = 0;
					}
				}
			}
			for(int i = 0;i<n;i++) {
				arr[numbers[i].x][numbers[i].y] = 2;
			}
			Queue<Data> q = new LinkedList<Data>();
			for(int d = 0; d<home.size();d++)
			{
				int minx = Integer.MAX_VALUE;
				int r = home.get(d).x;
				int c = home.get(d).y;
				int sum = 0;
				for(int i = 0;i<n;i++) {
					sum = Math.abs(r-numbers[i].x) + Math.abs(c-numbers[i].y);
					if(minx > sum) {
						minx = sum;
					}
				}
				ans+=minx;
				
				/*dist = new int[N][N];
				q.add(home.poll()); //집에서 출발
				dist[q.peek().x][q.peek().y] = 1;
					while(!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.peek().y;
					q.poll();
					for(int k = 0;k<4;k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || dist[nx][ny] != 0) continue;
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Data(nx,ny));
						if(arr[nx][ny] == 2) {
							ans += dist[nx][ny] - 1; //거리를 받음
							break;
						}
					}
				}*/
			}
			if(ans < min && ans != 0) {
				min = ans;
			}
			return;
		}else {
			for(int i = start; i<chicken.size();i++) {
				numbers[n] = chicken.get(i);
				comb(n+1,i+1);
			}
		}
	}
}
