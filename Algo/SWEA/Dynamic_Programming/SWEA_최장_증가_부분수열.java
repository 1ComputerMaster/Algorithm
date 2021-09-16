package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_최장_증가_부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(in.readLine());
			int arr[] = new int[N];
			StringTokenizer tk = new StringTokenizer(in.readLine()," ");
			int dp[] = new int[N];
			for(int i = 0;i<N;i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
				dp[i] = 1; //초기화
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			System.out.println("#"+t+" "+Arrays.stream(dp).max().getAsInt()); //배열 to stream max값 구하고 그것을 int형으로 
		}
	}
}
