package BOJ.simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15683_감시 {
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int ans = 0;
	static int [][] arr;
	static ArrayList<Data> o = new ArrayList<>();
	
	private static void dfs(int dir,int x,int y) {
		if(arr[x][y] == 1) {
			
		}else if(arr[x][y] == 2) {
			
		}else if(arr[x][y] == 3) {
			
		}else if(arr[x][y] == 4) {
			
		}else {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		arr = new int[R][C];
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] != 0) {
					o.add(new Data(i,j));
				}
			}
		}
		for(int i = 0; i<o.size();i++) {
			dfs(1,o.get(i).x,o.get(i).y);
		}
		System.out.println(ans);
		
	}
}
