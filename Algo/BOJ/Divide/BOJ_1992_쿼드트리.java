package Divide;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
/* 쿼드 트리 
 * 분할 정복 문제
 * 낮에 workshop 때 풀어보았던 문제와 비슷하여 쉽게 풀 수 있었다.
 * 정사각형으로 0값과 1 값만 탐색하니깐 sum으로 사각형 파악이 되었다.
 * 괄호 추가하는 것이 어려웠지만 재귀를 생각하면 당연하게 나와야 하는 것이였다.
 */

public class BOJ_1992_쿼드트리 {
	static String str = "";
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			String str = sc.next();
			for(int j = 0;j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		go(0,0,N,1);
		System.out.println(str);
		
		
	}
	private static void go(int x,int y,int size, int where) {
		int sum = 0;
		for(int i = x; i<x+size;i++)
		{
			for(int j = y; j<y+size;j++)
			{
				sum+=arr[i][j];
			}
		}
		if(sum == size*size) {
			str+="1";
			return;
		}
		else if(sum == 0)
		{	
			str+="0";
			return;
		}else {
			int half = size/2;
			str +="("; //재귀를 flat하게 생각하면 당연했던 것
			go(x,y,half,1);
			go(x,y+half,half,2);
			go(x+half,y,half,3);
			go(x+half,y+half,half,4);
			str +=")";
		}
	}
}
