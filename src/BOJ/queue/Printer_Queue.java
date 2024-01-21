package BOJ.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Printer_Queue {
static class Pair implements Comparable<Pair>{
	int num;
	int idx;
	public Pair(int num, int idx)  {
		this.num = num;
		this.idx = idx;
	}
	@Override
	public int compareTo(Pair o) {
		return this.num - o.num;
	}
}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Pair> q;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for(int test_case = 1;test_case<=T;test_case++) {
			int ans = 0;
			q= new LinkedList<Pair>();
			tk = new StringTokenizer(in.readLine()," ");
			int n; // 들어올 수의 갯수
			int idx; // 해당 위치의 숫자를 찾아야 함
			n = Integer.parseInt(tk.nextToken());
			idx = Integer.parseInt(tk.nextToken());
	/*		if(n == 1) {
				tk = new StringTokenizer(in.readLine()," "); //중요도 입력 받음
				System.out.println(1);
				break;
			}*/
			tk = new StringTokenizer(in.readLine()," "); //중요도 입력 받음
			for(int i = 0;i<n;i++) {
				int temp = Integer.parseInt(tk.nextToken());//1,2,3,4
				q.add(new Pair(temp,i)); //중요도 입력 받았다.
			}
			
			Pair max = Collections.max(q);
			 
			while(!q.isEmpty())
			{
				max = Collections.max(q);
				Pair temp =q.poll();
				if(max.num==temp.num) {
					ans++;
					if(max.idx == idx) {
						System.out.println(ans);
						break;
					}
				}else {
					q.add(temp);
				}
			}
		}
	}
}
