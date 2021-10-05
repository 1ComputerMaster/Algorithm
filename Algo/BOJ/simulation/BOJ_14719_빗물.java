package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	static int left,right;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int R = Integer.parseInt(tk.nextToken()); //높이
		int C = Integer.parseInt(tk.nextToken()); //가로
		int arr[] = new int[C];
		tk = new StringTokenizer(in.readLine()," ");
		int max = 0; // 3 . 0
		int ans = 0;
		for (int i = 0; i < C; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		// 인덱스마다 모이는 빗물 계산 ( 1번째 기둥과 마지막 기둥의 위치는 제외 ) -> left, right가 될 것
		for (int i = 1; i < C - 1; i++) {
			left = 0; right = 0;
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}
			for (int j = i; j < C ; j++) {
				right = Math.max(right, arr[j]);
			}
			if(arr[i] < left && arr[i] < right) {
				ans += Math.min(left, right) - arr[i];
			}
		}
		System.out.println(ans);
	}
}

