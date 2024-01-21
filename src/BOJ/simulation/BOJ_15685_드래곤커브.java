package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static int[][] arr = new int[101][101];
	static int end_x,end_y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int y = Integer.parseInt(tk.nextToken()); // x
			int x = Integer.parseInt(tk.nextToken()); // y
			int d = Integer.parseInt(tk.nextToken()); // 방향
			int g = Integer.parseInt(tk.nextToken()); // 세대
			ArrayList<Integer> dragon = new ArrayList<>();
			arr[x][y] = 1;
			// 0 세대는 직접 한 번 그림
			end_x = x + dx[d];
			end_y = y + dy[d];
			arr[end_x][end_y] = 1; // 그 곳 까지는 일단 간 곳으로 설정한다.
			dragon.add(d); //첫 방향을 주고
			for (int j = 0; j < g; j++) { // 세대 만큼 반복한다
				make_curve(dragon);
			}
		}
		int ans = 0;
	    for(int i=0; i<100; i++){
	        for(int j=0; j<100; j++){
	            if(arr[i][j] == 1 && arr[i][j+1] == 1 && arr[i+1][j] == 1 && arr[i+1][j+1] == 1){ //정사각형의 갯수를 세기
	                ans++;
	            }
	        }
	    }
	    System.out.println(ans);
	}
	private static void make_curve(ArrayList<Integer> dragon) {
		int size = dragon.size();
		for (int i = size - 1; i >= 0; i--) {
			int dir = (dragon.get(i) + 1)%4;
			end_x = end_x + dx[dir];
			end_y = end_y + dy[dir];
			arr[end_x][end_y] = 1;
			dragon.add(dir);
		}
	}

}
