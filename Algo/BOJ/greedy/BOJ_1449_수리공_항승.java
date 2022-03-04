package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1449_수리공_항승 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int L = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine()," ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(tk.nextToken()));
		}
		Collections.sort(list);
		
		int min = list.get(0);
		int temp = 0;
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i) - min;
			if(temp >= L) {
				min = list.get(i);
				cnt++;
			}
			if(i == list.size() - 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
