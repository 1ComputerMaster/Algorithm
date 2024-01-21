package SWEA;

import java.util.Scanner;

public class RC_Car {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T; test_case++) {
			int n = sc.nextInt();
			int v = 0;
			int ans = 0;
			while(n-- > 0) {
				int mod = sc.nextInt();
				if(mod == 0) {
					ans += v;
					continue;
				}
				int acc = sc.nextInt();
				
				if(mod == 1) {
					v += acc;
					ans += v;
				}
				if(mod == 2) {
					if(v - acc < 0) {
						v = 0;
					}
					else {
						v-=acc;
						ans += v;
					}
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}

}
