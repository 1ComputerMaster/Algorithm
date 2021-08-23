import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class swea_base_station {
	static class Pair{
		int x;
		int y;
		char z;
		public Pair(int x, int y,char z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	static int dx [] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1;test_case<=T;test_case++) {
			int n = Integer.parseInt(in.readLine());
			char[][] arr;
			arr = new char[n][n];
			ArrayList<Pair> list = new ArrayList();
			for(int i = 0; i<n;i++)
			{
				String str = in.readLine();
				for(int j = 0; j<n;j++) 
				{
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == 'A' || arr[i][j]=='B'||arr[i][j]=='C') {
						list.add(new Pair(i,j,arr[i][j]));
					}
				}
			}
			for(int i = 0;i<list.size();i++) {
				Pair p = list.get(i);
				int x = p.x;
				int y = p.y;
				char z = p.z;
				for(int d = 0; d<4;d++) {
					int cnt = 0;
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(z == 'A')
					{
						while(nx < n && nx >= 0 && ny < n && ny >= 0 && cnt < 1) {
							cnt++; // (0 - 1)
							if(arr[nx][ny] =='H') {
								arr[nx][ny] = 'X';
								break;
							} 
							nx+=dx[d];
							ny+=dy[d];
						}
					}
					if(z == 'B')
					{
						while(nx < n && nx >= 0 && ny < n && ny >= 0 && cnt < 2) {
							cnt++; // (0 - 1) (1 - 2)
							if(arr[nx][ny] =='H') {
								arr[nx][ny] = 'X';
								break;
							} 
							nx+=dx[d];
							ny+=dy[d];
						}
					}
					if(z == 'C')
					{
						while(nx < n && nx >= 0 && ny < n && ny >= 0 && cnt < 3) {
							cnt++; // (0 - 1) (1 - 2) (2 - 3) 
							if(arr[nx][ny] =='H') {
								arr[nx][ny] = 'X';
								break;
							} 
							nx+=dx[d];
							ny+=dy[d];
						}
					}
				}
			}
			int sum = 0;
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(arr[i][j] == 'H') {
						sum += 1;
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
