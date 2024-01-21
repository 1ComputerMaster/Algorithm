package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_숨바꼭질_1697 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);//처음 수빈 잇는 위치
		boolean check[] = new boolean[100001]; //갔는지 체크함
		check[N] = true;//일단 처음 위치는 갔다고 표식
		int cnt = 0;
		while(!q.isEmpty()) 
		{
			int size = q.size();//2
			for(int i = 0;i<size;i++) // 여기에 바로 q.size() 적으면 밑에서 q.poll()해서 다 못 돔
			{	
				int x = q.poll();
				if(x == K) 
				{
					System.out.println(cnt);
					return;
				}
				if(2*x <= 100000 && check[2*x] == false) {// 0 <= N,K <= 100000
					check[2*x] = true;
					q.add(2*x);
				}
				if(x + 1 <= 100000 && check[x+1] == false) {
					check[x+1] = true;
					q.add(x+1);
				}
				if(x - 1 >= 0 && check[x-1] == false) { 
					check[x-1] = true;
					q.add(x-1);
				}
			}
			cnt++;
		}
	}
}