package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static int V,E; //V : 노드 , E : 간선
	private static int ans = 100_000_00;
	
	public static void main(String[] args) throws IOException {
		//Floyd - Warshall로 손 쉽게 풀 수 있다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		V = Integer.parseInt(tk.nextToken());
		E = Integer.parseInt(tk.nextToken());
		int d[][] = new int[V+1][V+1];
		for(int map[] : d) {
			Arrays.fill(map, 100_000_000); //1억으로 다 채움
		}
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken()); //가중치
			d[from][to] = weight; //일방 통행이니깐
		}
		for (int k = 1; k < V+1; k++) { //경
			for (int i = 1; i < V+1; i++) { //출 
				for (int j = 1; j < V+1; j++) { //도
					if(i == j) {
						d[i][j] = 0;
					}
					d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
				}
			}
		}
		for (int k = 1; k < V+1; k++) { //경
			for (int i = 1; i < V+1; i++) { //출 
				if(i != k) //만약에 같은 곳이 아니라면 그곳에서 다시 갈 수 있는 곳 사이클인 곳 중 최소인 것을 출력하면 되니깐
				{
					ans  = Math.min(ans, d[i][k] + d[k][i]);
				}
			}
		}
		if(ans < 100_000_000)
		{
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
}
