package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_16206_롤케이크 {
static int cut;
static int ans;
private static ArrayList<Integer> arr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cut = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		arr2 = new ArrayList<>();
		for(int i = 0; i<N;i++) {
			int next = sc.nextInt();
			if(next%10 == 0) {
				arr2.add(next);
			}else
			{arr.add(next);}
		}
		Collections.sort(arr2);
		for(int i = 0;i<arr2.size();i++) {
			cut(arr2.get(i));
		}
		
		for(int i = 0;i<arr.size();i++) {
			cut(arr.get(i));
		}
		
		System.out.println(ans);
	}

	private static void cut(int x) {
		if(x==10) {
			ans++;
			return;
		}
		if(x<10) {
			return;
		}
		if(cut <= 0) {
			return;
		}
		else {
			x-=10;
			ans++;
			cut--;
			if(x > 10) {
				cut(x);
			}else if(x == 10) { //10인 경우
				ans++;
				return;
			}
		}
	}
}
