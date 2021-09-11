package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ_13913_숨바꼭질4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		boolean check[] = new boolean[100001]; //갔는지 체크함
		check[N] = true;//일단 처음 위치는 갔다고 표식
		int cnt = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i= 0;i<100000;i++)
		{
			list.add(new ArrayList<Integer>());
		}
		Stack<Integer> ans = new Stack<>();
		while(!q.isEmpty()) 
		{
			int size = q.size();
			for(int i = 0;i<size;i++) // 여기에 바로 q.size() 적으면 밑에서 q.poll해서 다 못 돔
			{	
				int x = q.poll();
				if(x == K) 
				{
					System.out.print(cnt);
					return;
				}
				if(2*x <= 100000 && check[2*x] == false) {
					check[2*x] = true;
					list.get(x).add(2*x);
					q.add(2*x);
				}
				if(x + 1 <= 100000 && check[x+1] == false) {
					check[x+1] = true;
					list.get(x).add(x+1);
					q.add(x+1);
				}
				if(x - 1 >= 0 && check[x-1] == false) {
					check[x-1] = true;
					list.get(x).add(x-1);
					q.add(x-1);
				}
			}
			cnt++;
		}
	}
}