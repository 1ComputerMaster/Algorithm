package SWEA.simulation;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 규영이와 인영이의 카드게임
 * 
 * 
 */
public class SWEA_CardGame {
	static int input[] = new int[9];
	static int numbers[] = new int[9];
	static int total = 0;
	static int total_lose = 0;
	static boolean[] check;
	static boolean[] isSel;
	static int arr[];
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[9];
		for(int T = 1;T<=N;T++) {
			check = new boolean[19];
			isSel = new boolean[9];
			
			win = 0;
			lose = 0;
			
			check[0] = true;
			for(int i = 0;i<9;i++)
			{
				arr[i] = sc.nextInt();
				check[arr[i]] = true;
			}
			
			int cnt = 0;
			for(int i = 1;i<=18;i++)
			{
				if(check[i]==false) {
					input[cnt++] = i;
				}
			}
			
			perm(0);
			
			System.out.println("#"+T+" "+win+" "+lose);
		}
		
	}
	private static void perm(int n) {
		if(n==9) {
			total = 0;
			total_lose = 0;
			for(int i = 0;i<9;i++) {
				if(arr[i]>numbers[i]) {
					total += (arr[i] + numbers[i]);
				}else if (arr[i] < numbers[i]){
					total_lose += (arr[i] + numbers[i]);
				}
			}
			if(total > total_lose) {
				win+=1;
			}
			else if(total < total_lose) {
				lose+=1;
			}
			return;
		}else {
			for(int i = 0;i<9;i++)
			{	
				if(isSel[i]) continue;
				isSel[i] = true;
				numbers[n] = input[i];
				perm(n+1);
				isSel[i] = false;
			}
		}
	}
	

}
