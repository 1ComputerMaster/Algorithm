package SWEA.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*	SWEA_1238_Contact
 * 당일 Graph를 배우고 나온 문제라
 * BFS로의 구현은 쉬웠으나 나머지 마지막 위치의 큐 사이즈 만큼 찾아서 나아가는게
 * 아이디어가 떠오르지 않아서 페어분의 아이디어를 빌려왔다.
 * 
 * 가장 마지막으로 들어오는 위치가 끝이므로
 * 그때의 다 같은 거리들을 뽑아서
 * 이때 가장 길어지는 위치 인덱스 값을 찾는 방식으로 가장 큰 숫자를 뺄 수 있었다.
 */
public class SWEA_1238_Contact {
	static ArrayList<Integer>[] list;
	static int N;
	static int M;
	static int ans;
	static int dist[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		for(int T = 1;T<=10;T++)
		{
			String str = in.readLine();
			tk = new StringTokenizer(str," ");
			N = Integer.parseInt(tk.nextToken());
			int V = Integer.parseInt(tk.nextToken()); //시작하는 정점
			dist= new int[N+1];
			list = new ArrayList[N+1];
			for(int i = 0;i<N+1;i++) {
				list[i] = new ArrayList();
			}
		
			String temp = in.readLine();
			tk = new StringTokenizer(temp," ");
			
			for(int i = 0;i<N/2;i++)
			{
				int from =Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				list[from].add(to);//방향성 그래프이다.
			}
			
			bfs(V);
			int max = 0;
			 for(int i=1;i<dist.length;i++){ //마지막꺼일때 몇번 돌았나 탐지 가능
	                if(max <= dist[i]){//리프 노드이니... 가장 마지막으로 큐가 탐색 할 것이고
	                    max = dist[i];//이때의 큐 몇번 돈지 저장하고
	                    ans = i;//i 값으로 제일 큰 값이 될때의 위치를 저장한다.
	                }
	            }
			System.out.println("#"+T+" "+ans);
		}
	}
	private static void bfs(int first) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(first);
		boolean check[] = new boolean[N+1];
		check[first] = true;
		dist[first]=1;
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i = 0;i <list[current].size();i++) {
				if(check[list[current].get(i)] == false) {
					q.add(list[current].get(i));
					dist[list[current].get(i)]=dist[current]+1; //거리 나아가면서
					check[list[current].get(i)]= true;
				}
			}
		}
		
	}
}
