import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hamburger_Diet {
	static class Pair{
		int point;
		int cal;
		public Pair(int point, int cal) {
			this.point = point;
			this.cal = cal;
		}
	}
	static int N;
	static int L;
	static Pair arr[];
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T;test_case++) {
			N = sc.nextInt(); //재료의 수
			L = sc.nextInt(); //칼로리
			arr = new Pair[N];
			for(int i = 0; i < N;i++) {
                int point =sc.nextInt();
                int cal = sc.nextInt();
				arr[i] = new Pair(point,cal); //맛 점수 , 칼로리
			}
			recursive(0,0,0);
			System.out.println("#"+test_case+" "+max);
		}
	}

	private static void recursive(int n,int point,int kcal) {
			if(kcal > L) {
				return;
			}
			if(n == N)
            {
                if(max < point)
                {
                	max = point;
                }
                return;
            }
			recursive(n+1,point+arr[n].point,kcal+arr[n].cal);
			recursive(n+1,point,kcal);
		
	}
}