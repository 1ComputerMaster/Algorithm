package SWEA.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_7699_수지의_수지_맞는_여행 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean alphabet[];
	static int R,C,ans;
	static char crr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for (int t = 1; t <= T; t++) {
			ans = 0;
			tk = new StringTokenizer(in.readLine()," ");
			R = Integer.parseInt(tk.nextToken());
			C = Integer.parseInt(tk.nextToken());
			crr = new char[R][C];
			alphabet = new boolean[26];
			for (int i = 0; i < R; i++) {
				String str = in.readLine();
				for (int j = 0; j < C; j++) {
					crr[i][j] = str.charAt(j);
				}
			}
			alphabet[crr[0][0] - 'A'] =  true;
			dfs(0,0,1);
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void dfs(int x,int y,int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C ) {
				continue;
			}
			if(alphabet[crr[nx][ny]-'A'] == false) {
				alphabet[crr[nx][ny] - 'A'] = true;
				dfs(nx,ny,cnt+1);
				alphabet[crr[nx][ny] - 'A'] = false; //거기로 안 간 경우를 체크 하기 위해서
			}
			
		}
	}
}
