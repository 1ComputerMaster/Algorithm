package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {
	static class Data implements Comparable<Data>{
		int from;
		int to;
		public Data(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.from, o.from);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Data arr[] = new Data[N];
		int dp[] = new int[N];
		for(int i = 0; i<N;i++) {
			dp[i] = 1;
			StringTokenizer tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			arr[i] = new Data(from,to);
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++){
		    for (int j = 0; j < i; j++){
		        if(arr[j].to < arr[i].to){
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }        
		    }
		}
		System.out.println(N-Arrays.stream(dp).max().getAsInt());
	}

}
