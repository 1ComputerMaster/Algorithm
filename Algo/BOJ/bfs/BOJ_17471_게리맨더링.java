package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N;
	static ArrayList<Integer> list[];
	static int weight[];
	private static boolean[] selected;
	private static boolean[] visited;
	private static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		weight = new int[N+1];
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		for (int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(tk.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int size = Integer.parseInt(tk.nextToken());
			for (int j = 0; j < size; j++) {
				list[i].add(Integer.parseInt(tk.nextToken()));
			}
		}
		ans = -1;
		selected = new boolean[N+1];
		Select(1);
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	private static void Select(int n) {
		if(n == N+1) {
			int area1 = 0;
            int area2 = 0;
            for(int i = 1; i <= N; i++) {
                if(selected[i] == true) area1 += weight[i];
                else area2 += weight[i];
            }
            visited = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();
            int link = 0;
            for (int i = 1; i <= N; i++) {
				if(!visited[i] &&  selected[i] == true) {
					link++;
					q.add(i);
					visited[i] = true;
					while (!q.isEmpty()) {
						int cur = q.poll();
						for (int next : list[cur]) {
							if(!visited[next] &&  selected[next] == true) {
								q.add(next);
								visited[next] = true;
							}
						}
					}
				}
				if(!visited[i] && selected[i] == false) {
					link++;
					q.add(i);
					visited[i] = true;
					while (!q.isEmpty()) {
						int cur = q.poll();
						for (int next : list[cur]) {
							if(!visited[next] &&  selected[next] == false) {
								q.add(next);
								visited[next] = true;
							}
						}
					}
				}
			}
            if(link == 2) {
            	if(ans == -1) {
            		ans=1000_000_000;
            	}
            	ans = Math.min(ans, Math.abs(area1 - area2)); 
            }
            return;
		}
		selected[n] = true;
		Select(n+1);
		selected[n] = false;
		Select(n+1);
	}
}