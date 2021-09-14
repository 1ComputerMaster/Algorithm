package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 
 * 처음에 RED , GREEN , BLUE 배열로 나누어서 접근하였으나
 * 각각 일차원 배열로 나누어서 접근하니깐 같은 번째 집에 다른 색깔을 min 값으로 가져가서
 * 이차원 배열 내에서 각기 다른 색깔로 접근하게 제작하였다.
*/

public class BOJ_1149_RGB_거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][3];
		for(int i = 0; i<N;i++) {
			arr[i][0] = sc.nextInt(); //RED
			arr[i][1] = sc.nextInt(); //BLUE
			arr[i][2] = sc.nextInt(); //GREEN
		}
		int min = Integer.MAX_VALUE; //초기화
		
		for(int i = 1;i<N;i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]); //그 전의 값을 가져와서 누적 
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]); //그 전의 값을 가져와서 누적
			arr[i][2] += Math.min(arr[i-1][1], arr[i-1][0]); //그 전의 값을 가져와서 누적
		}
		System.out.println(Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2])); // 최종에서 가장 작은 색을 골라야 함
	}

}
