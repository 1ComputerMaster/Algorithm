package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
/*	static class Data{
		int e;
		int w;
		public Data(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()); //도시의 개수
		int m = Integer.parseInt(in.readLine()); //버스의 개수
		
		//ArrayList<Data> list[] = new ArrayList[n+1]; 
		int arr[][] = new int[n][n];
		/*for(int i = 0;i<m;i++) {
			list[i] = new ArrayList<>();
		}*/
		for (int i = 0; i < m; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			if(arr[a-1][b-1] != 0 && arr[a-1][b-1] < c) {
				continue;
			}else {
			arr[a-1][b-1] = c;
			}
		}
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(i != j && arr[i][j] == 0)
				arr[i][j] = 1000_000_000;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(arr[i][j] == 1000_000_000) {
					arr[i][j] = 0;
				}
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}
