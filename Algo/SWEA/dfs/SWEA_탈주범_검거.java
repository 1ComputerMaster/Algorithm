package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BFS로 하였으면 훨씬 쉽게 빨리 풀렸을 것이나
 * 방문 체크를 잘 해주면 재귀를 쓰는 방식으로도 정답이 나온다고 하여 
 * dfs 방식을 채택해서 일일이 조건 체크하고 재귀를 돌려서 풀었습니다.
 */
public class SWEA_탈주범_검거 {
	static int N,M,R,C,L;
	static int arr[][],visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(tk.nextToken());//가로
			M = Integer.parseInt(tk.nextToken());//세로
			R = Integer.parseInt(tk.nextToken());//맨홀 위치 x좌표
			C = Integer.parseInt(tk.nextToken());//맨홀 위치 y좌표
			L = Integer.parseInt(tk.nextToken());//몇 초
			arr = new int[N][M];
			visited = new int[N][M];
			int ans = 0;
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			go(R,C,arr[R][C],0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] != 0)
					{
						ans++;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void go(int x,int y,int dir,int time) {
		time++;
		visited[x][y] = -1; //일단 바로 전에 들어오는 것을 체크 하기 위함 -> 이것이 없으면 시간초과가 난다 -> 이미 (x,y) 가는 것은 지금 다른 재귀에서 탐색 중인데 굳이 거기 또 들어와서 중복 체크 해서 시간을 늘릴 필요가 없다
		if(time == L) {
			return ;
		}
		if(dir == 1) {//상하좌우 모두 가능
			if((x - 1) >= 0 && (arr[x-1][y] != 3 && arr[x-1][y] != 4 && arr[x-1][y] !=7 && arr[x-1][y] != 0) && visited[x-1][y] != -1) //위로 한 칸
			{
				go(x-1,y,arr[x-1][y],time);
				visited[x-1][y] = 1;
			}
			if((y - 1) >= 0 && (arr[x][y-1]!=2 && arr[x][y-1]!=6 && arr[x][y-1]!=7 && arr[x][y-1] != 0) && visited[x][y-1] != -1) //왼쪽으로 한 칸
			{
				go(x,y-1,arr[x][y-1],time);
				visited[x][y-1] = 1;
			}
			if((x + 1) < N && (arr[x+1][y] !=3 && arr[x+1][y] != 5 && arr[x+1][y] != 6 && arr[x+1][y] != 0) && visited[x+1][y] != -1) //아래으로 한 칸
			{
				go(x+1,y,arr[x+1][y],time);
				visited[x+1][y] = 1;
			}
			if((y + 1) < M && (arr[x][y+1] != 2 && arr[x][y+1] != 4 && arr[x][y+1] != 5 && arr[x][y+1] != 0) && visited[x][y+1] != -1) //오른쪽으로 한 칸
			{
				go(x,y+1,arr[x][y+1],time);
				visited[x][y+1] = 1;
			}
		}
		else if(dir == 2) {
			if((x - 1) >= 0 && (arr[x-1][y] != 3 && arr[x-1][y] != 4 && arr[x-1][y] !=7 && arr[x-1][y] != 0) && visited[x-1][y] != -1) //위로 한 칸
			{
				go(x-1,y,arr[x-1][y],time);
				visited[x-1][y] = 1;

			}
			if((x + 1) < N && (arr[x+1][y] !=3 && arr[x+1][y] != 5 && arr[x+1][y] != 6 && arr[x+1][y] != 0) && visited[x+1][y] != -1) //아래으로 한 칸
			{
				go(x+1,y,arr[x+1][y],time);
				visited[x+1][y] = 1;
			}
		}
		else if(dir == 3) {
			if((y - 1) >= 0 && (arr[x][y-1]!=2 && arr[x][y-1]!=6 && arr[x][y-1]!=7 && arr[x][y-1] != 0) && visited[x][y-1] != -1) //왼쪽으로 한 칸
			{
				go(x,y-1,arr[x][y-1],time);
				visited[x][y-1] = 1;
			}
			if((y + 1) < M && (arr[x][y+1] != 2 && arr[x][y+1] != 4 && arr[x][y+1] != 5 && arr[x][y+1] != 0) && visited[x][y+1] != -1) //오른쪽으로 한 칸
			{
				go(x,y+1,arr[x][y+1],time);
				visited[x][y+1] = 1;
			}
		}
		else if(dir == 4) {
			if((x - 1) >= 0 && (arr[x-1][y] != 3 && arr[x-1][y] != 4 && arr[x-1][y] !=7 && arr[x-1][y] != 0) && visited[x-1][y] != -1) //위로 한 칸
			{
				go(x-1,y,arr[x-1][y],time);
				visited[x-1][y] = 1;
			}
			if((y + 1) < M && (arr[x][y+1] != 2 && arr[x][y+1] != 4 && arr[x][y+1] != 5 && arr[x][y+1] != 0) && visited[x][y+1] != -1) //오른쪽으로 한 칸
			{
				go(x,y+1,arr[x][y+1],time);
				visited[x][y+1] = 1;
			}
		}
		else if(dir == 5) {
			if((x + 1) < N && (arr[x+1][y] !=3 && arr[x+1][y] != 5 && arr[x+1][y] != 6 && arr[x+1][y] != 0) && visited[x+1][y] != -1) //아래으로 한 칸
			{
				go(x+1,y,arr[x+1][y],time);
				visited[x+1][y] = 1;
			}
			if((y + 1) < M && (arr[x][y+1] != 2 && arr[x][y+1] != 4 && arr[x][y+1] != 5 && arr[x][y+1] != 0) && visited[x][y+1] != -1) //오른쪽으로 한 칸
			{
				go(x,y+1,arr[x][y+1],time);
				visited[x][y+1] = 1;
			}
		}
		else if(dir == 6) {
			if((x + 1) < N && (arr[x+1][y] !=3 && arr[x+1][y] != 5 && arr[x+1][y] != 6 && arr[x+1][y] != 0) && visited[x+1][y] != -1) //아래으로 한 칸
			{
				go(x+1,y,arr[x+1][y],time);
				visited[x+1][y] = 1;
			}
			if((y - 1) >= 0 && (arr[x][y-1]!=2 && arr[x][y-1]!=6 && arr[x][y-1]!=7 && arr[x][y-1] != 0) && visited[x][y-1] != -1) //왼쪽으로 한 칸
			{
				go(x,y-1,arr[x][y-1],time);
				visited[x][y-1] = 1;
			}
		}
		else if(dir == 7) {
			if((x - 1) >= 0 && (arr[x-1][y] != 3 && arr[x-1][y] != 4 && arr[x-1][y] !=7 && arr[x-1][y] != 0) && visited[x-1][y] != -1) //위로 한 칸
			{
				go(x-1,y,arr[x-1][y],time);
				visited[x-1][y] = 1;

			}
			if((y - 1) >= 0 && (arr[x][y-1]!=2 && arr[x][y-1]!=6 && arr[x][y-1]!=7 && arr[x][y-1] != 0) && visited[x][y-1] != -1) //왼쪽으로 한 칸
			{
				go(x,y-1,arr[x][y-1],time);
				visited[x][y-1] = 1;
			}
		}
	}
}