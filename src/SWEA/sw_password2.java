package SWEA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/*
 * LinkedList를 이용한 구현 문제
 */
public class sw_password2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;//암호문 길이 0~999999 수 나열
		LinkedList<Integer> pw; //원본 암호문
		int wordN;//명령어의 갯수
		for(int test_case = 1;test_case<=10;test_case++)
		{
			pw =  new LinkedList<Integer>();//초기화 유념하기
			N = sc.nextInt();
			for(int i = 0; i<N;i++)
				pw.add(sc.nextInt());
			wordN = sc.nextInt();
			for(int i = 0; i<wordN;i++)
			{
				String st = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(st.equals("I"))
				{
					for(int j = 0; j<y;j++) {
					pw.add(x+j, sc.nextInt());
					}
				}
				else if(st.equals("D")) {
					for(int j = 0; j<y;j++) {
						pw.remove(x);
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i = 0; i<10;i++)
			{
				System.out.print(pw.get(i)+" ");
			}
			System.out.println();
		}
	}
}
