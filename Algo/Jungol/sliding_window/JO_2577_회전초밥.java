package sliding_window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JO_2577_회전초밥 {
	static int N,d,k,c; //접시 갯수, 초밥 가짓수, 연속 선택, 쿠폰 번호
	static int[] ds,ts; // ds -> 전체 접시 정보 / ts -> 타입 정보 (2,3,2,3) => 2 => 다른 배열의 값을 다른 배열의 첨자로 활용
	static int tcnt = 0; //선택된 초밥의 타입의 갯수
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken()); // 접시의 수
		d = Integer.parseInt(tk.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(tk.nextToken()); // 연속된 접시의 수 
		c = Integer.parseInt(tk.nextToken()); // 쿠폰 번호
		ds = new int[N]; //N개 만큼 만듦
		ts = new int[d]; //내가 먹는 초밥의 갯수 만큼
		for (int i = 0; i < N; i++) {
			ds[i] = Integer.parseInt(in.readLine()); //현재 위치의 초밥의 종류를 넣는다.
		}
		//쿠폰은 무조건 먹는다.
		push(c);
		//맨 앞에서 부터 (k - 1)까지 무조건 먹는다고 하자
		for (int i = 0; i < k - 1; i++) {
			push(ds[i]);
		}
		int ans = 0;
		//k 번째부터 N까지 다음 것 추가하고 맨 앞에 거 제거해보기
		for (int i = k - 1; i < N + (k - 1) ; i++) {
			push(ds[i%N]);
			ans = Math.max(ans, tcnt);
			pop(ds[(i-(k-1))%N]);
		}
		//출력
		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
	}
	//현재 초밥을 선택함
	private static void push(int idx) { //초밥의 번호
		//첨자 변환 => 30 -> 29 / 1 -> 0
		if(ts[idx - 1] == 0) { //만약에 그 전에 들어온것이 없다면
			tcnt++;
		}
		ts[idx - 1]++; //방문 체크
	}
	private static void pop(int idx) {
		ts[idx - 1]--;
		if(ts[idx - 1] == 0) { //하나도 안 먹음
			tcnt--;
		}
	}
}
