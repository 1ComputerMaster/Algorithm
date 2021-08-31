import java.util.Arrays;
import java.util.Scanner;

public class Spot_Mart {
	static int N;
	static int M;
	private static int[] numbers;
	static int a[];
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T;test_case++) {
			max = 0;
			N = sc.nextInt();//최대 몇개
			M = sc.nextInt();//M그램시 못듬
			a = new int[N];
			numbers = new int[N];
			for(int i = 0; i < N;i++) {
				a[i] = sc.nextInt();
			}
			comb(0,0);
			if(max == 0) {
				max = -1;
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
	private static void comb(int n, int start) {
		if(n == 2) {
			int temp = 0;
			for(int i =0;i<2;i++) {
				temp += a[numbers[i]];
			}
			if(M >= temp) {
				if(max < temp) {
					max = temp;
				}
			}
			return;
		}
		for(int i = start; i<N;i++) {
			numbers[n] = i;
			comb(n+1,i+1);
		}
	}

}
