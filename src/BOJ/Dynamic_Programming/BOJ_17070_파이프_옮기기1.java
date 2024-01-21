package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기1 {
	static int arr[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer tk;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		System.out.println(go(0,1,0));
	}
	private static int go(int x,int y,int z) {
		int ans = 0;
		if(x == N-1 && y == N-1) {
			return 1;
		}
		if(z == 0) {//가로이면
			if (y + 1 <= N-1 && arr[x][y + 1] == 0) {
				ans += go(x,y+1,0);
			}
			if(x+1<=N-1 && y+1<=N-1 && arr[x+1][y+1]==0 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0) {
				ans += go(x+1,y+1,1);//대각선
			}
		}
		else if(z == 1) {
			if(x + 1 <= N-1 && arr[x + 1][y] == 0) {
				ans += go(x+1,y,2);
			}
			if (y + 1 <= N-1 && arr[x][y + 1] == 0) {
				ans += go(x,y+1,0);
			}
			if(x+1<=N-1 && y+1<=N-1 && arr[x+1][y+1]==0 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0) {
				ans += go(x+1,y+1,1);//대각선
			}
		}
		else if(z == 2) {//세로이면
			if(x + 1 <= N-1 && arr[x + 1][y] == 0) {
				ans += go(x+1,y,2);
			}
			if(x + 1 <= N-1 && y + 1 <= N-1 && arr[x + 1][y + 1] == 0 && arr[x][y+1] == 0 && arr[x+1][y] == 0) {
				ans += go(x+1,y+1,1);//대각선
			}
		}
		return ans;
	}
}
