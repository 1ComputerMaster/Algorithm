package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수_구하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		go(N,M);
	}
	private static void go(int n,int m) {
		boolean check = false;
		for (int j = n; j <= m; j++) {
			if(j == 1) continue;
			check = false;
			for (int i = 2; i*i <= m ; i++) {
				if(j%i == 0 && i != j) {
					check = true;
					break;
				}
			}
			if(check == false) {
				System.out.println(j);
			}
		}
	}
}
