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
		Collections.sort(list); //정렬
		
		int min = list.get(0); // 가장 작은 수를 받는다
		int temp = 0;
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i) - min;// 작은 위치와 비교해서
			if(temp >= L) { // 항승이가 막는 테이프 길이 보다 그 차이가 크거나 같다면
				min = list.get(i); // 그러면 min 값 재 갱신
				cnt++;
			}
			if(i == list.size() - 1) { //어짜피 하나는 무조건 써야 하니 쓴다. -> 무조건 하나는 막아야 하니깐
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
