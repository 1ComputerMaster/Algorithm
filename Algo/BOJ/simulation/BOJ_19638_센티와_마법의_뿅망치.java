package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19638_센티와_마법의_뿅망치 {
	static long N,H,T,max;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		H = Integer.parseInt(tk.nextToken());
		T = Integer.parseInt(tk.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		max = 0;
		long cnt = T;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			pq.add(Long.parseLong(tk.nextToken()));
		}
		boolean visited = true;
		while(T > 0) {
			long temp = pq.poll(); // max 값이 나온다.
			if(temp == 1) {
				pq.add(temp);
				cnt -= T;
				break;
			}
			if(temp >= H) {
				temp = temp/2;
				pq.add(temp);
				T--;
			}else {
				cnt -= T;
				break;
			}
		}
		max = pq.peek();
		
		if(max < H) {
			System.out.println("YES");
			System.out.println(cnt);
		}else {
			System.out.println("NO");
			System.out.println(max);
		}
	}

}
