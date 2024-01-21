package SWEA.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4013_특이한_자석 {
	static int K;
	static ArrayList<Integer> a[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(in.readLine());
			a = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				a[i] = new ArrayList<>();
			}
			
			tk = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < 8; i++) {
				a[1].add(Integer.parseInt(tk.nextToken()));
			}
			
			tk = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < 8; i++) {
				a[2].add(Integer.parseInt(tk.nextToken()));
			}
			
			tk = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < 8; i++) {
				a[3].add(Integer.parseInt(tk.nextToken()));
			}
			
			tk = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < 8; i++) {
				a[4].add(Integer.parseInt(tk.nextToken()));
			}
			
			for (int i = 0; i < K; i++) { // K 번 돌면서 다 체킹
				tk = new StringTokenizer(in.readLine()," ");
				int num = Integer.parseInt(tk.nextToken());//몇번째
				int wheels = Integer.parseInt(tk.nextToken()); //시계 반시계
				wheels(num,wheels);
			}
			int cnt = 0;
			for (int i = 1; i < 5; i++) {
				if(a[i].get(0) == 1) {
					cnt += Math.pow(2, (i-1));
				}
			}
			System.out.println("#"+t+ " "+ cnt);
		}
	}
	private static void wheels (int num,int wheel){
		check = new boolean[5];
		if(num % 2 == 1) { // 홀 수 일때
			if(num == 1) {
				check[1] = true;
				if(a[1].get(2) != a[2].get(6)) { //다르면 돌리고
					check[2] = true;
					if(a[2].get(2) != a[3].get(6)) {
						check[3] = true;
						if(a[3].get(2) != a[4].get(6)) {
							check[4] = true;
						}
					}
				}
			}
			if(num == 3) {
				check[3] = true;
				if(a[3].get(2) != a[4].get(6)) { //다르면 돌리고
					check[4] = true;
				}
				if(a[3].get(6) != a[2].get(2)) {
					check[2] = true;
					if(a[2].get(6) != a[1].get(2)) {
						check[1] = true;
					}
				}
			}
			for (int i = 1; i < 5; i++) {
				if(check[i]) {
					if(i == 1 || i == 3) {
						if(wheel == 1) {//시계
							int temp = a[i].get(7);
							a[i].remove(7);
							a[i].add(0,temp);
						}
						else {//반시계
							int temp = a[i].get(0);
							a[i].remove(0);
							a[i].add(temp);
						}
					}
					else {
						if(wheel == 1) {//반시계
							int temp = a[i].get(0);
							a[i].remove(0);
							a[i].add(temp);
						}
						else {//시계방향
							int temp = a[i].get(7);
							a[i].remove(7);
							a[i].add(0,temp);
						}
					}
				}
			}
		}else {
			if(num == 2) {
				check[2] = true;
				if(a[2].get(6) != a[1].get(2)) { //다르면 돌리고
					check[1] = true;
				}
				if(a[2].get(2) != a[3].get(6)) {
					check[3] = true;
					if(a[3].get(2) != a[4].get(6)) {
						check[4] = true;
					}
				}
			}
			if(num == 4) {
				check[4] = true;
				if(a[4].get(6) != a[3].get(2)) { //다르면 돌리고
					check[3] = true;
					if(a[3].get(6) != a[2].get(2)) {
						check[2] = true;
						if(a[2].get(6) != a[1].get(2)) {
							check[1] = true;
						}
					}
				}
			}
			for (int i = 1; i < 5; i++) {
				if(check[i]) {
					if(i == 2 || i == 4) {
						if(wheel == 1) {//시계
							int temp = a[i].get(7);
							a[i].remove(7);
							a[i].add(0,temp);
						}
						else {//반시계
							int temp = a[i].get(0);
							a[i].remove(0);
							a[i].add(temp);
						}
					}
					else {
						if(wheel == 1) {//반시계
							int temp = a[i].get(0);
							a[i].remove(0);
							a[i].add(temp);
						}
						else {//시계방향
							int temp = a[i].get(7);
							a[i].remove(7);
							a[i].add(0,temp);
						}
					}
				}
			}
		}
	}
}
