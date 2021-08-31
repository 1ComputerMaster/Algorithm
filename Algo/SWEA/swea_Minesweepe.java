import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//1868 파핑파핑 지뢰찾기
public class swea_Minesweepe {
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
	static int n;
	static boolean[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
			n = Integer.parseInt(in.readLine());
			char crr [][] = new char[n][n];
			check = new boolean[n][n];
			for(int i = 0;i<n;i++) {
				String str = in.readLine();
				crr[i] = str.toCharArray();
			}
			
			
			
			
			
		}
	}
	
	static void dfs(int x,int y,char crr[][]) {
		for(int i = 0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
				continue;
			}
			if(check[nx][ny] == true)
			{
				continue;
			}
			if(crr[nx][ny]=='.')
			{
				check[nx][ny] = true;
				dfs(nx,ny,crr);
			}
		}
	}
}
