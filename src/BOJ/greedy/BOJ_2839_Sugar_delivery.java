package BOJ.greedy;

import java.util.Scanner;

public class BOJ_2839_Sugar_delivery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // Nkg를 배달 해야 한다.
		int ans = 0;
		for(int i = 0;i<N/3;i++)
		{
			if((N-(3*i))%5 == 0) {
				if(i == 0) {
					ans = ((N-(3*i))/5);
					System.out.println(ans);
					return;
				}else {
					ans = ((N-(3*i))/5);//1
					System.out.println(ans+i);
					return;
				}
			}
		}
		if(N%3 == 0) {
			ans = (N/3);
			System.out.println(ans);
			return;
		}
		System.out.println("-1");
	}
}
