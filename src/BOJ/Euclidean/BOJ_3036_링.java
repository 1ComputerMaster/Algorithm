package BOJ.Euclidean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3036_링 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int []arr = new int[N];
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		for (int i = 1; i < N; i++) {
			System.out.println(arr[0]/gcd(arr[0],arr[i])+"/"+arr[i]/gcd(arr[0],arr[i]));
		}
	}
	private static int gcd(int m,int n) {
		int temp = 0;
		while(n > 0) {
			temp = m%n;//0
			m = n;
			n = temp;
		}
		return m;
	}
}
