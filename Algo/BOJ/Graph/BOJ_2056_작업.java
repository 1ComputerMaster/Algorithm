package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {
	static int N;
	static int cnt[];
	static int time[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		cnt = new int[N + 1]; //1,2,3,4,5,6 번을 정리하자
		time = new int[N + 1]; //시간을 가짐
		StringTokenizer tk;
		int M;
		int ans = 0;
		ArrayList<Integer> graph[] = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N+1; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			time[i] = Integer.parseInt(tk.nextToken()); //시간
			M = Integer.parseInt(tk.nextToken()); 
			if(M == 0) {
				cnt[i] = 0;//첫 번째 진입 차수는 0이다.
				continue;
			}else { //뒤에 더 있다는 것
				for (int j = 0; j < M; j++) {
					graph[Integer.parseInt(tk.nextToken())].add(i); //M번 만큼 차수를 지우기 위해서...
					cnt[i]++; 
				}
			}
		}
		ans = topology_sort(graph,cnt,time);
		System.out.println(ans);
	}
	private static int topology_sort(ArrayList<Integer>[] graph, int[] cnt, int[] time) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1]; // time이 가장 큰 값을 가져와야 한다 -> 진입 차수가 같은 상황에서 사실 상 가장 큰 수의 타임이 들어오면
		// 다음번에 다시 한 번 작은 값을 지나쳐서 큰 값을 들어올리가 없으므로
		for (int i = 1; i < N + 1; i++) {
			result[i] = time[i];
			if (cnt[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll(); // 하나씩 내 위치에서 그 다음 차수로 빼온다.
			for (int next : graph[now]) { 
				cnt[next]--; // 가는 만큼 차수가 끊어짐
				result[next] = Math.max(result[next], result[now] + time[next]); // 한 번에 가는 경우가 더 긴 작업이 있을 경우
				// 같이 차수가 없어지기 때문에 앞의 작업이 끝나기 전에 먼저 끝나는 경우가 생길 수 있다.
				/* 예시)
				5
				6 0
				3 0
				30 2 1 2
				1 1 1
				1 2 3 4
				*/
				// 새롭게 차수가 0이 된 작업을 큐에 넣음.
				if (cnt[next] == 0) {
					q.offer(next);
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, result[i]);
		}
		return ans;
	}
}
