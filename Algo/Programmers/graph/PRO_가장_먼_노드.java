package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PRO_가장_먼_노드 {
	
	public static void main(String[] args) {
		int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,edge));
	}
	static ArrayList<Integer> graph[];
	static int dist[];
	static boolean visited[];
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
        	int from = edge[i][0];
        	int to = edge[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }
        visited[1] = true;
		dijkstra(1);
		int max = 0;
		for(int i = 1; i < dist.length; i++) {
			if(max < dist[i]) {
				max = dist[i];
				answer = 1;
			}
			else if(max == dist[i]) {
				answer++;
			}
		}
        return answer;
    }
	private static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()) {
        	int cur = q.poll(); //내가 갈 곳
        	for(int i = 0; i < graph[cur].size(); i++) {
        		if(visited[graph[cur].get(i)] == false) {
        			q.add(graph[cur].get(i));//이 곳에서 다시 찾아본다.
        			visited[graph[cur].get(i)] = true;// 이곳은 본 곳
        			dist[graph[cur].get(i)] = dist[cur] + 1; //한 번 거쳐 갈게요
        		}
        	}
        }
	}
}
