package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374_강의실 {
	static class Data implements Comparable<Data>{
		int start;
		int end;
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.start, o.start);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		ArrayList<Data> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int num = Integer.parseInt(tk.nextToken());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			list.add(new Data(start,end));
		}
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);
		int m = 1;
		for (int i = 1; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= list.get(i).start)
			{
				pq.poll();
			}
			pq.add(list.get(i).end);
			m = Math.max(m, (int)pq.size());
		}
		System.out.println(m);
	}

}
