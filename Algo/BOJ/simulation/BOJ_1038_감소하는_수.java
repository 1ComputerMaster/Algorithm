package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * 부분 집합의 성질을 이용해서 만든 문제
 * 뽑고 안 뽑고를 이용
 */
public class BOJ_1038_감소하는_수 {
	static ArrayList<Integer>[] list;
	static int num[]; 
	static boolean isSelected[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		list = new ArrayList[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		num = new int[] {0,1,2,3,4,5,6,7,8,9};
		isSelected = new boolean[10];
		ans = new ArrayList<>();
		dfs(0);
		Collections.sort(ans);
		if(ans.size() <= n) {
			System.out.println(-1);
		}else {
			System.out.println(ans.get(n));
		}
	}
	static ArrayList<Long> ans;
	static StringBuilder sb;
	private static void dfs(int idx) {
		if(idx == 10) {
			String str = "";
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					str += num[i];
				}
			}
			if(str == "") {
				return;
			}
			char[] crr = str.toCharArray();
			Arrays.sort(crr);
			sb = new StringBuilder(new String(crr));
			ans.add(Long.parseLong(sb.reverse().toString()));
		}else {
			isSelected[idx] = true; // 선택 한 경우
			dfs(idx+1);
			isSelected[idx] = false; //선택 안 한 경우
			dfs(idx+1);
		}
	}
}
