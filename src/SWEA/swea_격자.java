package SWEA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class swea_격자 {

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static int arr[][];
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		arr = new int[4][4];
		for(int test_case = 1;test_case<=T;test_case++)
		{
			for(int i = 0;i<4;i++)
			{
				for(int j = 0;j<4;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0;i<4;i++)
			{
				for(int j = 0;j<4;j++) {
					dfs(i,j,0,0);
				}
			}
			System.out.println("#"+test_case+" "+ set.size());
		}
	}
	static void dfs(int x,int y,int cnt,int sum) {
		if(cnt == 7) {
			set.add(sum);
			return ;
		}
		for(int i = 0 ;i<4;i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 4 || ny >= 4 || nx < 0 || ny < 0) {
				continue;
			}
	        dfs(nx, ny, cnt+1, sum+(int)Math.pow(10, cnt)*arr[nx][ny]);
		}
	}
	
	
	
	}

