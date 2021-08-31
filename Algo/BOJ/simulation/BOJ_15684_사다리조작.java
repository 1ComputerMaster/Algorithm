package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	static int w,h;
	static int garo[][] = new int[100][100];
	static class Data{
		int first;
		int second;
		public Data(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	static int start(int c) {
		int r = 1;
		while (r <= h) {
			if (garo[r][c] == 1) {
				c += 1;
			}
			else if (garo[r][c] == 2) {
				c -= 1;
			}r += 1;
		}return c;
	}

	static boolean go() {
		for (int i = 1; i <= w; i++) {
			int res = start(i);
			if (res != i) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		w = Integer.parseInt(tk.nextToken());//세로선
		int M = Integer.parseInt(tk.nextToken());
		h = Integer.parseInt(tk.nextToken());
		
		for(int i = 0;i<M;i++) { //이미 가로선 다 놓음
			tk = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			garo[a][b]=1;
			garo[a][b+1]=2;
		
		}
		ArrayList<Data> a = new ArrayList();
		for (int i = 0; i <= h; i++) {
			for (int j = 0; j <= w - 1; j++) {
				if (garo[i][j] != 0) continue;
				if (garo[i][j + 1] != 0)continue;
				a.add(new Data(i, j));//i,j에 추가함
			}
		}
		int ans = -1;
		if (go()) {
			System.out.println(0);
			return ;
		}
		int len = a.size();
		for (int i = 0; i < len; i++) {
			int x1 = a.get(i).first;
			int y1 = a.get(i).second;
			garo[x1][y1] = 1;
			garo[x1][y1 + 1] = 2;
			if (go()) {
				if (ans == -1 || ans > 1) {
					ans = 1;
				}
			}
			for (int j = i + 1; j < len; j++) {
				int x2 = a.get(j).first;
				int y2 = a.get(j).second;
				if (garo[x2][y2] != 0 || garo[x2][y2 + 1] != 0) continue;
				garo[x2][y2] = 1;
				garo[x2][y2 + 1] = 2;
				if (go()) {
					if (ans == -1 || ans > 2) {
						ans = 2;
					}
				}
				for (int k = j + 1; k < len; k++) {
					int x3 = a.get(k).first;
					int y3 = a.get(k).second;
					if (garo[x3][y3] != 0 || garo[x3][y3 + 1] != 0) continue;
					garo[x3][y3] = 1;
					garo[x3][y3 + 1] = 2;
					if (go()) {
						if (ans == -1 || ans > 3) {
							ans = 3;
						}
					}
					garo[x3][y3] = 0;
					garo[x3][y3 + 1] = 0;
				}
				garo[x2][y2] = 0;
				garo[x2][y2 + 1] = 0;
			}
			garo[x1][y1] = 0;
			garo[x1][y1 + 1] = 0;
		}
		System.out.println(ans);
		return ;
	}
}
