package SWEA.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 계속 아이디어를 못찾고 있던 터에 한 블로그에서 소개한 방법을 그대로 착안하여 구현만 해본 문제
 * 규칙이 보면 근처에 폭탄이 있으면 더이상 못가고 있다. 그리고 그 전까지는 계속 연쇄 폭발로 나아간다는것을 착안
 * 
 * 
 * 
 * 
 */

public class SWEA_1868_파핑파핑_지뢰찾기 {
	static char arr[][];
    static public int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
    static public int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int N,ans;
    static class Data{
    	int x;
    	int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for (int t = 1; t <= T; t++) {
			ans= 0;
			N = Integer.parseInt(in.readLine());
			arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == '.' && check(i,j)) {
						bfs(i,j);
						ans++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == '.') {
						ans++;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<SWEA_1868_파핑파핑_지뢰찾기.Data>();
		q.add(new Data(x,y));
		while(!q.isEmpty()) {
			Data start = q.poll();
			arr[start.x][start.y] = '0';
			 for(int i=0; i<8; i++) {
	                int nx = start.x + dx[i];
	                int ny = start.y + dy[i];
	                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	                //visited 배열 쓸 거 없이 여기서 더이상 갈 수 없음을 맵으로 표시한다.
	                if(arr[nx][ny] == '0' || arr[nx][ny] == '1') continue;
	                // 주변에 폭탄이 있는지 확인
	                if(!check(nx,ny)) {
	                    //더이상 연쇄 폭발을 막음
	                    arr[nx][ny] = '1';
	                }else {
	                	//아니면 탐색 가능 계속가자
	                    arr[nx][ny] = '0';
	                    q.add(new Data(nx, ny));
	                }
	            }
	        }
	    }
	private static boolean check(int x,int y) {
		for (int i = 0; i < 8; i++) { //8방 탐색시
			int nx = x + dx[i];
			int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(arr[nx][ny] == '*') { //보니깐 근처에 폭발물 있네? -> 더이상 못 가 BFS 중지
				return false;
			}
		}
		return true;
	}
}
