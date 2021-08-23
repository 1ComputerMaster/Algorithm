package bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*BOJ_1987 알파벳
 * 
 * 같은 문자 안 겹치고 최대한 나아간 거리들을 출력하는 문제 한쪽에서 간거 + 한쪽에서 간거 + ... 최대한으로
 * 
 * 재귀 + 백트래킹 문제
 * 
 * 하나의 길을 갈 때마다 체크해서 dfs 처럼 나아간다.
 * 
 * 처음에 BFS로 제작 후 str.length가 가장 길어지는 것을 빼내려고 하였으나 q가 얼마나 돌지 알 수 없어서 일일이 str을 다 만들수가 없다.
 * bfs 특성상 다시 백트래킹이 불가능하였다.(이전 노드의 정보를 넣으면 될 수 있겠으나.. 당시에 직관적으로 떠오르지 않았다)
 * 
 * -> 백트래킹을 이용해서 갔던거 다시 와서 푸는 식으로 하면서 리턴 값에서 +1이 되면서 돌아야 하므로
 * 새로운 변수로 그 전에 있던 값들을 저장하고 다시 받고 이런식으로 반복
 * 
 */
public class BOJ_1987 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int R;
	static int C;
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
		int ans = 0;//ans 재귀 리턴 될 때 마다 값을 더해주기 위해서
		for(int i = 0;i<4;i++) {
			int nx = x+dx[i];//다음으로 가기 위함
			int ny = y+dy[i];
			if(nx < 0 || nx >= R || ny >= C || ny < 0) continue; //배열 조건
			if(check[str[nx].charAt(ny) - 'A'] == false) {
				check[str[nx].charAt(ny) - 'A'] = true;
				int next = dfs(nx,ny,str,check); //하나에서 제일  오래 가는 길이 구하고
				ans = Math.max(next, ans); //ans와 비교해서 더 큰 값을 받는다.결국 하나의 길에서 가장 멀리 가므로...
				check[str[nx].charAt(ny) - 'A'] = false;//다시 돌아가기 위해서 받고
			}
		}
		return ans + 1; // 리턴 값을 더해주기 위함
	}
}	

