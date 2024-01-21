package BOJ.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x));
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(in.readLine());
			if(v == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(v);
			}
		}
	}
}