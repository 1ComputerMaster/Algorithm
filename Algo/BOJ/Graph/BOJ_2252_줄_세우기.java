package Graph;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 위상 정렬 문제
 *  큐에 먼저 들어오는 간선이 없는 것들을 저장하고
 *  그 다음에 큐로 부터 나아가는 것들에 대해서 간선이 작은 것들을 큐에 저장하고 출력하고를 반복하여 푼 문제
 *  위상정렬 : 어떤 하는 일의 순서를 구하는 알고리즘 -> 하나의 방향 그래프에는 여러 위상 정렬이 가능하다.
 * 
 * 
 */
public class BOJ_2252_줄_세우기 {
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken()); //학생 수
		M = Integer.parseInt(tk.nextToken()); //세울 수
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int cnt[] = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			list[from].add(to);
			cnt[to] += 1;
		}
		for (int i = 1; i < N+1; i++) {
			if(cnt[i] == 0) { //처음 시작
				q.add(i); // queue add
			}
		}
		// 정점의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            int v = q.poll(); // 1. 큐에서 정점 추출
            System.out.print(v + " "); // 정점 출력

            // 2. 해당 정점과 연결된 모든 정점에 대해
            for (int nextV : list[v]) {
                cnt[nextV]--; // 2-1. 간선의 수 감소
                // 2-2. 선행 정점을 가지지 않는 정점을 큐에 삽입
                if (cnt[nextV] == 0) { // 해당 정점의 간선의 수가 0이면
                    q.add(nextV);
                }
            }
        }
	}
}
