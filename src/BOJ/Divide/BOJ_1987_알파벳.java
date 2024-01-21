package BOJ.Divide;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1987_알파벳 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int R;
	static int C;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		boolean check[] = new boolean[R*C];
		String str[] = new String[R];
		String ans;
		for(int i = 0;i<R;i++) {
			str[i] = sc.next();
		}
		check[str[0].charAt(0)-'A'] = true;
		System.out.println(dfs(0,0,str,check));
		
	}
	private static int dfs(int x, int y, String[] str, boolean[] check) {
		int ans = 0;
		for(int i = 0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx < 0 || nx >= R || ny >= C || ny < 0) continue;
			if(check[str[nx].charAt(ny) - 'A'] == false) {
				check[str[nx].charAt(ny) - 'A'] = true;
				int next = dfs(nx,ny,str,check); //여기 갔다 와야하니깐 next로 일단 두고
				ans = Math.max(next, ans); // 더 큰 놈이 더 오래 많이 갔다는 것이니 더 큰놈을 줌
				check[str[nx].charAt(ny) - 'A'] = false;
			}
		}
		return ans + 1;
	}
}	
