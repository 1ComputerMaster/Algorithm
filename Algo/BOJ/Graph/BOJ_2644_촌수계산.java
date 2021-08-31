package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	static int N;
	static int pointy;
	static int pointx;
	static boolean[] check;
	static int cnt = 0;
	static int[] dist;
	static int list[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk ;
		N = Integer.parseInt(in.readLine());
		tk = new StringTokenizer(in.readLine()," ");
		
		pointx =Integer.parseInt(tk.nextToken());
		pointy =Integer.parseInt(tk.nextToken());
		int T = Integer.parseInt(in.readLine());
		list = new int[N+1][N+1];
		check = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i = 0;i<T;i++) {
			String str = in.readLine();
			tk = new StringTokenizer(str," ");
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			
			list[start][end] = 1;
			list[end][start] = 1;
			
			
		}
		Queue<Integer> q = new LinkedList<>();
		check[pointx] = true;
		q.add(pointx);
		int temp;
		while (!q.isEmpty())
		{
			temp = q.peek(); 
			q.poll();
			for (int j = 1; j <= N; j++)
			{
				if (list[temp][j] == 1 && !check[j])
				{
					check[j] = true;
					dist[j] = dist[temp] + 1;//촌수 + 1
					q.add(j);
				}
			}
		}
		if(dist[pointy] == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(dist[pointy]);
	}
}
