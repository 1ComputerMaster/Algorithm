package BOJ.bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_11559_Puyo_Puyo {
	static char crr[][] = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int ans = 0;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Data> v;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		v = new ArrayList();
		int tempY = -1;
		for (int i = 0; i < 12; i++) {
			String str = in.readLine();
			for (int j = 0; j < 6; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		while(true) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(crr[i][j] != '.' && visited[i][j] == false) {
						bfs(i,j);
						if(v.size() >= 4) { //부술 수 있다.
							check = true;
						}
						else {
							int size = v.size();
							for (int j2 = 0; j2 < size; j2++) {
								visited[v.get(j2).x][v.get(j2).y] = false;
							}
						}
						v.clear();
					}
				}
			}
			
			if(check) { // true이면
				ans++;
			}
			else if(check == false) {
				break;
			}
			for (int i1 = 0; i1 < 12; i1++) {
				for (int j1 = 0; j1 < 6; j1++) {
					if (visited[i1][j1] == true) {
						crr[i1][j1] = '.';
					}
				}
			}
			for (int i = 12 - 2; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					tempY = -1;
					if (crr[i][j] != '.') {
						tempY = isBottomDot(i, j);
					}
					if (tempY != -1) {
						crr[tempY][j] = crr[i][j]; // 가장 마지막 . 이 나온 곳으로 옮기고,
						crr[i][j] = '.'; // 그 자리에 . 을 대입한다.
					}
				}
			}
			check = false;
			for (int j2 = 0; j2 < 12; j2++) {
					for (int k = 0; k < 6; k++) {
						visited[j2][k] = false;
					}
				}
			}
		System.out.println(ans);
	}
	private static int isBottomDot(int y, int x){
		int tempY = -1;
		for (int i = y; i < 12; i++) {
			if (crr[i][x] == '.') {
				tempY = i;
			}
		}
		return tempY;
	}
	private static void bfs(int x,int y) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		v.add(new Data(x,y));
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny] || crr[nx][ny] != crr[cur.x][cur.y]) {
					continue;
				}
				v.add(new Data(nx,ny));
				visited[nx][ny] = true;
				q.add(new Data(nx,ny));
			}
		}
	}
}
