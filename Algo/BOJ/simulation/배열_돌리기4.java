package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class 배열_돌리기4 {
	static int r;
	static int c;
	static int s;
	static class tuple{
		int r,c,s;
		public tuple(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[][] = new int[n+1][m+1];
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=m;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		tuple[] t = new tuple[k];
		for(int k1 = 0;k1<k;k1++)
		{	
			r = sc.nextInt();
			c = sc.nextInt();
			s = sc.nextInt();
			t[k1] = new tuple(r, c, s);
		}
		go(arr,t[0]);
			
	}
	private static void go(int arr[][],tuple t) {
		int row = r;
		int col = c;
		int size = s;
		//Vector<Vector<Integer>> groups =new Vector<>();
		ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
		for (int s = 1; s <= size; s++) {
			ArrayList<Integer> group = new ArrayList();
			//(r-s,c-s) -> (r-s,c+s)
			for (int r = row - s, c = col - s; c < col + s; c++) {
				group.add(arr[r][c]);
			}
			// (r-s, c+s) -> (r+s, c+s)
			for (int r = row - s, c = col + s; r < row + s; r++) {
				group.add(arr[r][c]);
			}
			// (r+s, c+s) -> (r+s, c-s)
			for (int r = row + s, c = col + s; c > col - s; c--) {
				group.add(arr[r][c]);
			}
			// (r+s, c-s) -> (r-s, c-s)
			for (int r = row + s, c = col - s; r > row - s; r--) {
				group.add(arr[r][c]);
			}
			groups.add(group);
		}
		for (int s = 1; s <= size; s++) {
			Collections.reverse(groups.get(s-1));
			int index = 0;
			//(r-s,c-s) -> (r-s,c+s)
			for (int r = row - s, c = col - s; c < col + s; c++) {
				arr[r][c] = groups.get(s-1).get(index++);
			}
			// (r-s, c+s) -> (r+s, c+s)
			for (int r = row - s, c = col + s; r < row + s; r++) {
				arr[r][c] = groups.get(s-1).get(index++);
			}
			// (r+s, c+s) -> (r+s, c-s)
			for (int r = row + s, c = col + s; c > col - s; c--) {
				arr[r][c] = groups.get(s-1).get(index++);
			}
			// (r+s, c-s) -> (r-s, c-s)
			for (int r = row + s, c = col - s; r > row - s; r--) {
				arr[r][c] = groups.get(s-1).get(index++);
			}
		}
	}
}
