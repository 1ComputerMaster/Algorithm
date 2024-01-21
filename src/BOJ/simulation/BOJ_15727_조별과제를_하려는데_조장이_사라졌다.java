package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15727_조별과제를_하려는데_조장이_사라졌다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(in.readLine());
		int cnt = 0;
		while(L > 0) {
			L-=5;
			cnt++;
		}
		System.out.println(cnt);
	}

}
