package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 아이디어 : 조합으로 3개의 벽을 놓을 곳을 뽑은 다음 바이러스를 시작점으로 두고 거기서 부터 bfs로 돌린다.
 * 반복해서 해서 arr[i][j] == 0 이 되는 것이 가장 많은 것을 답으로 출력한다.
 */

public class BOJ_14502_연구소 {
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int M;
	static int numbers[] = new int[3];
	static boolean checked[][] = new boolean[N][M];
	static ArrayList<Data> v;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		v = new ArrayList<>(); //바이러스의 시작 위치 bfs로 탐색
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) {
					v.add(new Data(i,j));
				}
			}
		}
		comb(0,0);
		System.out.println(max);
	}
	static int temp[][] = new int[N][M];
	static int max = Integer.MIN_VALUE;
	private static void comb(int n,int start){
		if(n==3) { //벽이 3개니깐
			checked = new boolean[N][M];//다시 초기화 하고 들어감
			temp = new int[N][M];

			for(int i = 0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					temp[i][j] = arr[i][j];
				}
			}
						
			for(int i = 0;i<3;i++) {
				if(temp[numbers[i]/M][numbers[i]%M]==2 || temp[numbers[i]/M][numbers[i]%M]==1) {
					return;
				}
				temp[numbers[i]/M][numbers[i]%M] = 1;
			}
			
			bfs();
			int cnt = 0;
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					if(temp[i][j] == 0) {
						cnt++;
					}
				}
			}
			if(max < cnt) {
				max = cnt;
			}
			return;
		}else {
			for(int i = start;i<N*M;i++) {	
				numbers[n]=i;
				comb(n+1,i+1);
			}
		}
	}
	private static void bfs() {
		for(int i = 0;i<v.size();i++) {
			Queue<Data> q = new LinkedList<>();
			q.add(v.get(i));
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				checked[x][y] = true;
				q.poll();
				for(int d = 0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx < 0 || nx>=N || ny >= M || ny < 0) continue;
					if(checked[nx][ny] == true) continue;
					if(temp[nx][ny] != 0 ) continue; 
					temp[nx][ny] = 2;
					checked[nx][ny] = true;
					q.add(new Data(nx, ny));
				}
			}
		}
	}
}
