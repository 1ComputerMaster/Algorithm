package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class swea_farm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T;test_case++)
		{
			int n = sc.nextInt();
			int[][]arr = new int[n][n];
			int mid = n/2;
			int sum = 0;
			char[] crr = new char[n];
			for(int i =0;i<n;i++) {
				String str = sc.next();
				crr = str.toCharArray();
				for(int j = 0; j<n;j++) {
					arr[i][j]=crr[j]-'0';
				}
			}
			for(int i = 0; i<mid;i++) {
				int j = i;
				while(j>=0) {
					if(j == 0) {
						sum += arr[i][mid];
						break;
					}
					sum += arr[i][mid+j] + arr[i][mid-j];
					j--;
				}
			}
			for(int j=0;j<n;j++) {
				sum+=arr[mid][j];
			}
			int cnt = n;
			for(int i = 0; i<mid;i++) {
				cnt--;
				int j = i;
				while(j>=0) {
					if(j == 0) {
						sum += arr[cnt][mid];
						break;
					}
					sum += arr[cnt][mid+j] + arr[cnt][mid-j];
					j--;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
		
	}

}
