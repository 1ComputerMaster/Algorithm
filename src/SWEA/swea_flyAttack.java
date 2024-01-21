package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

class swea_flyAttack
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][n];
            int ans = 0;
            for(int i = 0; i <n;i++) {
            	for(int j = 0; j <n;j++) {
            		arr[i][j] = sc.nextInt();
            	}
            }
            
            for(int i = 0; i <n;i++) {
            	for(int j = 0; j <n;j++) {
            		int temp = 0;
            		for(int k = 0;k<m;k++) {
            			for(int d = 0;d<m;d++) {
            				if(i+k >= 0 && j+d < n && j+d >= 0 && i+k < n)
            				{
            					temp+=arr[i+k][j+d];
            				}
            			}
            		}
            		if(ans < temp) {
            			ans = temp;
            		}
            	}
            }
            
            
            
			System.out.println("#"+test_case+" "+ ans);
		}
	}
}