package MST;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BOJ_1197_MST {
	static class Data implements Comparable<Data>{
		int end;
		int weight;
		public Data(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return this.weight - o.weight;
		}
	}
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int V = Integer.parseInt(tk.nextToken()); //정점의 갯수
		int E = Integer.parseInt(tk.nextToken()); //간선의 갯수
		ArrayList<Data>[] list = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i = 0;i<V+1;i++) {
			list[i] = new ArrayList();
		}
		
		for(int i = 0;i<E;i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken());
			list[from].add(new Data(to,weight));
			list[to].add(new Data(from,weight));
			
		}
		PriorityQueue<Data> q = new PriorityQueue<Data>();
		q.offer(new Data(1,0)); //자기 자신은 0
		int cnt = 0;
		int res = 0;
		while(!q.isEmpty()) {
			
			//1.MST에 포함 되지 않은 정점 중 최소 간선 비용의 무조건 정점 찾기
			//	Priority Q이니깐 비용이 싼 거 부터 나오기 때문에 정리할 필요가 없구나..
			Data cur = q.poll(); // logN이 되어져버림 왜냐? PriorityQueue가 바로 정렬해 버린 것을 바로 poll로 뽑아내니
			if(visited[cur.end]) {//한번 등록된 곳은 다시 나오면 안됨 PriorityQueue를 쓰지 않게 되는 것과 같은 효과가 됨 -> 가지치기
				continue;
			}
			visited[cur.end] = true;//이제 이 정점은 신장트리에 포함시키니깐 true
			res+=cur.weight;//이때의 비용을 결과에 누적한다.
			cnt++;
			if(cnt == V) { //모든 정점이 선택됨 -> 가지치기 (N-1)번 돌았으므로 MST를 위한 모든 간선이 선택되었다.
				break;
			}
			//2. 선택된 정점 기준으로 신장 트리에 연결 되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for (int j = 0; j < list[cur.end].size(); j++) {
				if(!visited[list[cur.end].get(j).end]) {
					q.offer(new Data(list[cur.end].get(j).end,list[cur.end].get(j).weight));//값을 업데이트함 내가 다시 가지는 곳으로 기준으로 minEdge 배열을 업데이트함
					//그러면 minEdge가 가장 최소의 간선 들로만 초기화 되면서 업데이트가 될 것임 -> 그럼 다시 그 minEdge 배열 기준으로 또 찾음
				}
			}
		}
		System.out.println(res);
	}
}
