package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Food_2961 {
static class Data{
	long stink;
	long bitter;
	public Data(long stink, long bitter) {
		super();
		this.stink = stink;
		this.bitter = bitter;
	}
}
	static long stink = 1;
	static long bitter = 0;
	static Data[] arr;
	static int N;
	static boolean isSel[];
	static long min = Long.MAX_VALUE; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Data[N];
		isSel = new boolean[N];
		for(int i = 0;i<N;i++) {
			long stink = sc.nextLong();
			long bitter = sc.nextLong();
			arr[i] = new Data(stink,bitter);
		}
		generate(0);
		System.out.println(min);
	}
	private static void generate(int n) {
		if(N == n) {
			boolean check = false;
			stink = 1;
			bitter = 0;
			for(int i = 0;i<n;i++)
				{
					if(isSel[i])
					{
						stink *= arr[i].stink;
						bitter += arr[i].bitter;
						check = true;
					}
					
				}
			if(stink-bitter < 0) {
				if(bitter-stink < min && check == true) {
					min = bitter-stink;
				}
			}else {
				if(stink-bitter < min && check == true) {
					min = stink-bitter;
				}
			}
			return ;
		}
		else {
			isSel[n] = true;
			generate(n+1);
			isSel[n] = false;
			generate(n+1);
		}
	}
}
