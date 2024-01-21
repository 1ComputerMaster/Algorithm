package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598_최소_회의실_개수 {
	static class Data implements Comparable<Data>{
		int start;
		int end;
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.start,o.start);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		int N = Integer.parseInt(in.readLine());
		int start = 0;
		int end = 0;
		ArrayList<Data> list = new ArrayList<Data>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			start = Integer.parseInt(tk.nextToken());
			end = Integer.parseInt(tk.nextToken());
			list.add(new Data(start,end));
		}
		Collections.sort(list);//시작 시간이 제일 작은 걸로 잡았을때
		pq.add(list.get(0).end); // 그 시작 시간이 가장 작은 애랑 끝나는 시간이 겹치는 애들은 무조건 들어오는 애들
		int m = 1;
		for (int i = 1; i < N; i++)
		{
			while (!pq.isEmpty() && pq.peek() <= list.get(i).start)
			{
				pq.poll(); // 5~10 초 짜리 들어가고 난 후  얘는 start 보다 작으니깐 나가진다.
			}
			pq.add(list.get(i).end); // 15~ 30초 들어감
			m = Math.max(m, (int)pq.size());
		}
		System.out.println(m);
		
	}
}
