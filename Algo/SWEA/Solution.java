/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int dx[] = {1,0,0};//상하좌우
	static int dy[] = {0,-1,1};
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;//테케 번호
			T=sc.nextInt();
			boolean check[][] = new boolean[100][100];
			int arr[][] = new int[100][100];
			
			Queue<Pair> q = new LinkedList<Pair>();
			
			
			for(int i = 0;i<100;i++)
			{
					for(int j = 0; j<100;j++) {
						arr[i][j] = sc.nextInt();
					}
			}
			int ans = 0;
			for(int i = 0; i <100;i++)
			{
			boolean check[][] = new boolean[100][100];
			Pair p1 = new Pair(i,0);
			q.add(p1);
			while(q.isEmpty()!=true)
			{
				Pair p = q.peek();
				int x = p.getX();
				int y = p.getY();
				q.remove();
				
				for(int d = 0;d<4;d++)
				{	
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx<0 || ny < 0 || ny>=100||nx>=100)
						continue;
					if(arr[nx][ny]==2) {
						ans = i;
						break;
					}
					if(arr[nx][ny]!=1) {
						continue;
					}
					if(arr[x][y] == 2) {
						ans = i;
						break;
					}
					if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && check[nx][ny] == false && arr[nx][ny] == 1) {
						p.setX(nx);
						p.setY(ny);
						q.add(p);
						check[nx][ny] = true;
					}
				}
			}
		}
			
		System.out.println("#"+T+" "+ans);

			for(int i = 0;i<100;i++)
			{
					for(int j = 0; j<100;j++) {
						arr[i][j] = sc.nextInt();
					}
			}
			int ans = 0;
			for(int i = 0;i<100;i++)
			{
				//for(int j = 0; j<100;j++) {
					if(arr[i][0]==0) //여기서 출발
					{ continue; }
					ans=recursive(arr,check,i,0);
				//}
			}
			System.out.println(ans);
		}
		
	}
	private static int recursive(int[][]arr,boolean check[][],int x,int y) {
		for(int k = 0;k<4;k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx >= 100 || ny >= 100 || nx < 0 || ny < 0)
				continue;
			if(arr[nx][ny] == 0 && check[nx][ny] == true) {
				continue;
			}
			if(arr[nx][ny]==2) {
				return x;
			}
			if(arr[nx][ny] == 1) {
				check[nx][ny] = true;
				return recursive(arr,check,nx,ny);
			}
		}
		return x;
	}
	
}*/

import java.util.Scanner;


public class Solution {
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		int T = sc.nextInt();
		int arr[][] = new int[100][100];
		
		Pair start = new Pair(0,0);
		
		for(int i = 0;i<100;i++) {
			for(int j = 0;j<100;j++) 
			{
				arr[i][j]=sc.nextInt();
			
			if(arr[i][j]==2) {
				start = new Pair(i,j);
			}
			}
		}
		
		for(;start.x>=0;start.x--) {
			if(start.y-1>=0&&arr[start.x][start.y-1]==1)
			{	
				while(start.y-1>=0&&arr[start.x][start.y-1]==1) {
					start.y--;
				}
			}
			else if(start.y+1<100&&arr[start.x][start.y+1]==1)
			{	
				while(start.y+1<100&&arr[start.x][start.y+1]==1) {
					start.y++;
				}
			}
		}

		System.out.println("#"+T+" "+start.y);
		}
		
	}

}



