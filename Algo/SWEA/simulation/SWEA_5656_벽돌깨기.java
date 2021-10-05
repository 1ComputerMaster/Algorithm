package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int N;
	static int W;
	static int H;
	static int arr[][];
	static int ans = Integer.MAX_VALUE;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int number[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			tk = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(tk.nextToken()); //몇번 치기
			W = Integer.parseInt(tk.nextToken()); //가로
			number = new int[N];
			H = Integer.parseInt(tk.nextToken()); //높이
			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				tk = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			perm(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	private static int[][] copy_map(int[][] map,int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}
	private static int[][] destory(int map[][],int x,int y) {
		int temp = map[x][y];
		map[x][y] = 0;
		for (int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];
			int cnt = 1;
			while(nx >= 0 && nx < H && ny >= 0 && ny < W) { //조건에 맞으면 계속 반복
				if(cnt == temp) {
					break;
				}
				cnt++; //아니면 반복
				if(map[nx][ny] > 1) {
					map = destory(map,nx,ny);
				}
				map[nx][ny] = 0;
				nx += dx[j];
				ny += dy[j];
			}
		}
		return map;
	}
	private static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void perm(int r) {
		if(r == N) {
			int map[][] = new int[H][W];
			copy_map(map,arr);
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < H; k++) { //깊이
					if(map[k][number[i]] != 0)
					{		
						map = destory(map,k,number[i]);
						move(map);
						break;
					}
				}
			}
			ans = Math.min(ans,count(map));
			return;
		}
		for (int i = 0; i < W; i++) {
			number[r] = i; 
			perm(r+1);
		}
	}
	private static void move(int[][] map) {
		Queue<Integer> temp;
		for(int w = 0 ; w < W ; ++w) {
			temp = new LinkedList<>();
			for(int h = H - 1 ; h >= 0 ; --h) {
				if(map[h][w] > 0) temp.offer(map[h][w]);
			}
			for(int h = H - 1 ; h >= 0 ; --h) {
				if(!temp.isEmpty()) {
					map[h][w] = temp.poll();
				} else {
					map[h][w] = 0;
				}
			}
		}
	}
}
