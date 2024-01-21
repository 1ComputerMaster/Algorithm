package BOJ.Euclidean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613_GCD_합 {
	static int arr[],visited[];		
	static int n,ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int T = Integer.parseInt(tk.nextToken());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			tk = new StringTokenizer(in.readLine()," ");
			n = Integer.parseInt(tk.nextToken());
			arr = new int[n];
			visited = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
			}
			for (int i = n-1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if(i != j)
						ans+=GCD(arr[i],arr[j]);
				}
			}
			System.out.println(ans/2);
		}
		
	}
	private static void comb(int[] visited,int start, int r) {
		if(r == 2) {
			int one = -1;
			int two = -1;
			boolean check = false;
			for (int i = 0; i < n; i++) {
				if(visited[i] == 1 && check == false) {
					one = i;
					check = true;
				}else if(visited[i] == 1 && check == true) {
					two = i;
				}
			}
			if(one == -1 || two == -1) {
				return;
			}
			ans += GCD(arr[one],arr[two]);
		}
		for (int i = start; i < n; i++) {
			visited[i] = 1;
			comb(visited,i+1,r+1);
			visited[i] = 0;
		}
	}
	private static int GCD(int m,int n){
		int temp;
		while(n != 0) {
			temp = m%n;
			m=n;
			n= temp;
		}
		return m;
	}
}
