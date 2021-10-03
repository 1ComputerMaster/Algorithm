package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 다익스트라로 계속 돌렸을때
 * 정확성: 50.0
 * 효율성: 18.3
 * 합계: 68.3 / 100.0
 * 
 * 처음에는 단순 무식하게 dijkstra로 해서 그냥 다 체킹 하는 방식으로 짰는데 효율성에서 낮은 점수를 받았다
 * -> 모든 거 다가보니깐 Floyd - Warshall
 * -> 또는 A 그리고 B 그리고 S 로 부터 만나는 한 노드를 구해서 거기로 가는 최소 값들을 찾으면 됨 다익스트라 3번해서 구할 수 있다.
 */
public class Pro_KAKAO_BLIND_합승_택시_요금 {
	/*static class Data implements Comparable<Data>{
		int end;
		int weight;
		public Data(int end,int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int dist[];
	static boolean visited[];
	private static ArrayList<Data> list[];
	static int N;
  public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
		N=n;
        list = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < fares.length; i++) {
			int from = fares[i][0];
			int to = fares[i][1];
			int weight = fares[i][2];
			list[from].add(new Data(to,weight));
			list[to].add(new Data(from,weight));
		}
		answer = Math.min(answer, dijkstra(s,a)+dijkstra(s,b)); //따로 가는 경우
		for (int i = 1; i < n+1; i++) { //나머지 같이 합석해서 가는 경우들
			answer = Math.min(answer, dijkstra(s,i) + dijkstra(i,b) + dijkstra(i,a));
		}
		return answer;
	}
	private static int dijkstra(int start,int end) {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		Arrays.fill(dist, 100_000_000);
		pq.add(new Data(start,0));
		int cnt = 0;
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			if(visited[cur.end]) {
				continue;
			}
			cnt += cur.weight;
			visited[cur.end] = true;
			for (int i = 0; i < list[cur.end].size(); i++) {
				if(dist[list[cur.end].get(i).end] >= dist[cur.end] + list[cur.end].get(i).weight)
				{
					dist[list[cur.end].get(i).end] = dist[cur.end] + list[cur.end].get(i).weight;
					pq.add(new Data(list[cur.end].get(i).end,dist[list[cur.end].get(i).end]));
				}
			}
		}
		return dist[end];
	}*/
	
	/*
	 * 정확성: 50.0
	 * 효율성: 48.3
	 * 합계: 98.3 / 100.0
	 */
	static int d[][];
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 1000_000_000;
        d = new int[n+1][n+1];
        for(int map[] : d) {
        	Arrays.fill(map, 100_000_000); 
        }
        for (int i = 0; i < fares.length; i++) {
			int from = fares[i][0];
			int to = fares[i][1];
			int weight = fares[i][2];
			d[from][to] = weight;
			d[to][from] = weight;
        }
        for (int k = 1; k < n+1; k++) { //경유지
        	for (int i = 1; i < n+1; i++) {//출
    			for (int j = 1; j < n+1; j++) { //도착
    				if(i != j) {
    					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    				}
    			}
    		}
		}
        for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				System.out.print(d[i][j] + " ");
			}System.out.println();
		}
        answer = Math.min(answer, d[s][a] + d[s][b]); //따로 가는 거
        for (int i = 1; i < n+1; i++) {
            if(i == a) {
                 answer = Math.min(answer, d[s][i] + d[i][b]); //같이 가는데 a랑 같으면 두번 더하니깐
         	}else if(i == b) {
                 answer = Math.min(answer, d[s][i] + d[i][a]); //같이 가는데 b랑 같으면 두번 더하니깐
         	}else if(i == s){
         		continue;//위에서 이미 함
         	}else{
                 answer = Math.min(answer, d[s][i] + d[i][a] + d[i][b]); //나머지
            }
 		}
        return answer;
    }
}
