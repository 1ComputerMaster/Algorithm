package BOJ.permutation;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 구현은 쉬우나 조건 맞추기가 까다로운 문제
 */
public class BOJ_1759_암호만들기 {
	static int R;
	static int N;
	static char[] ans;
	static String srr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		srr = new String[R];
		ans = new char[N];
		for(int i = 0;i<R;i++)
			srr[i]=sc.next();
		Arrays.sort(srr);
		comb(0,0);
	}
	private static void comb(int n,int start) {
		if(n==N) {
			int cnt = 0;
			 for(int i = 0;i<ans.length;i++)
	         {
				 if(ans[i] == 'a'|| ans[i] == 'e'|| ans[i]== 'i'||ans[i]== 'o'||ans[i]== 'u')
				 {
					 cnt++;
				 }
	         }
			 if(cnt != 0 && cnt < N-1)
			 {
				 for(int i = 0;i<ans.length;i++)
		            {
					 	System.out.print(ans[i]);
		            }System.out.println();
			 }
			 return;
		}else{
			for(int i =start;i<R;i++) {
				ans[n]=srr[i].charAt(0);
				comb(n+1,i+1);
			}
		}
	}
}
