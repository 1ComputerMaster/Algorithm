package permutation;

import java.util.Scanner;

/*
 * 일곱 난쟁이 문제
 * 순서 상관 없으니 조합이용
 * 
*/
public class BOJ_Princess_3040 {
	static boolean [] isSelected = new boolean[9];
	static int sum = 0;
	static int arr[];
	static boolean check = false;
	static int[] numbers = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i= 0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		comb(0,0);
		
	}
	private static void comb(int n,int start) {
		if(n==7) {
			sum = 0;
			for(int i = 0;i<7;i++)
				sum+=numbers[i];
			if(sum == 100) {
				for(int i = 0;i<7;i++)
				System.out.println(numbers[i]);
			}
			return;
			
		}else {
			for(int i = start;i<9;i++)
			{
				numbers[n] = arr[i];
				comb(n+1,i+1);
			}
		}
	}
}
