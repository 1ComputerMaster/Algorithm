package SWEA;

import java.util.Scanner;

public class swea_Ladder1 {
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
