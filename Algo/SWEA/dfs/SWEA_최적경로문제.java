package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_최적경로문제 {
static class Data{
	int x;
	int y;
	
	public Data() {
	}
	public Data(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
private static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test = 1;test <=T; test++) {
			int n = sc.nextInt();
			Data work = new Data(sc.nextInt(),sc.nextInt());
			Data house = new Data(sc.nextInt(),sc.nextInt()); //얘는 어짜피 무조건 맨 마지막으로 가야함
			Data arr[] = new Data[n];
		
		}
		
	}

}
