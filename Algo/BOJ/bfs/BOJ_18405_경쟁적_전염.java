package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18405_경쟁적_전염 {
	static int arr[][],check[][];
	static int N,K;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static ArrayList<Weight> list;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Weight implements Comparable<Weight>{
		int x;
		int y;
		int w;
		public Weight(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Weight o) {
			return this.w - o.w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		arr = new int[N][N];
		list = new ArrayList<Weight>();
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				if(arr[i][j] != 0) {
					list.add(new Weight(i,j,arr[i][j]));
				}
			}
		}
		tk = new StringTokenizer(in.readLine()," ");
		int S = Integer.parseInt(tk.nextToken());
		int X = Integer.parseInt(tk.nextToken());
		int Y = Integer.parseInt(tk.nextToken());
		check = new int[N][N];
		int temp[][] = new int[N][N];
		for (int l = 0; l < S; l++) {
			temp = Copy_Arr(temp,arr);
			Collections.sort(list);
			int size = list.size();
				for (int i = 0; i < size; i++) {
					Weight w = list.get(0);
					list.remove(0);
					temp = bfs(w.x,w.y,temp);
				}
				arr = Copy_Arr(arr,temp);
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(check[j][k] == 2) {
							check[j][k] = 0;
						}
					}
				}
		}
		System.out.println(arr[X-1][Y-1]);
	}

	private static int[][] Copy_Arr(int[][] temp, int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	private static int[][] bfs(int x, int y,int arr[][]) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		check[x][y] = 1;
 		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= N || nx < 0 || ny < 0 || ny >= N || check[nx][ny] == 1 || arr[nx][ny] != 0) {
					continue;
				}
				check[nx][ny] = 2;
				arr[nx][ny] = arr[x][y];
				list.add(new Weight(nx,ny,arr[nx][ny]));
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}System.out.println();
			}System.out.println("========================");
			return arr;
		}
		return arr;
	}
}

