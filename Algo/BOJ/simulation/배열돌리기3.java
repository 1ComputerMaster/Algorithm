package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 배열돌리기3 {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mod;
		N = sc.nextInt();
		M = sc.nextInt();
		mod = sc.nextInt();
		int arr[][] = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		LinkedList<Integer> temp;
		LinkedList<Integer> temp2;
		int cnt = 0;
		for(int i = 0;i<mod;i++) { //연산의 수
			
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				for(int j = 0;j<M;j++) {
					temp = new LinkedList();
					for(int k = 0; k<N;k++) {
						temp.add(arr[k][j]); //값 넣음
							if(k == (N-1)) {
								Collections.reverse(temp);
								for(int k1 = 0; k1<N;k1++) {
									arr[k1][j] = temp.poll();
								}
							}
						}
					}
				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(arr[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			case 2:
				for(int j = 0;j<N;j++) {
					temp = new LinkedList();//임시로 계속 객체 다시 받음
					for(int k=0;k<M;k++) {
						temp.add(arr[j][k]);
						if(k == (M-1)) {
							Collections.reverse(temp);
							for(int j1 = 0; j1<M;j1++) {
								arr[j][j1] = temp.poll();
							}
						}
					}
				}
				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(arr[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			case 3:
				cnt++;
				int rotate[][] = new int[M][N];
				temp = new LinkedList();//임시로 계속 객체 다시 받음
				for(int r = 0;r<N;r++) {
					for(int c = 0; c<M;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int c = N-1;c>=0;c--) {
					for(int r = 0;r<M;r++) {
						rotate[r][c] = temp.poll();
					}
				}
				arr = rotate;
				int tempM = M;
				M=N;
				N=tempM;
				
				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(rotate[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			case 4:
				cnt++;
				int rotate1[][] = new int[M][N];
				temp = new LinkedList();//임시로 계속 객체 다시 받음
				for(int r = 0;r<N;r++) {
					for(int c = 0; c<M;c++) {
						temp.add(arr[r][c]);
					}
				}
				Collections.reverse(temp);
				for(int c = N-1;c>=0;c--) {
					for(int r = 0;r<M;r++) {
						rotate1[r][c] = temp.poll();
					}
				}
				arr = rotate1;
				int tempM1 = M;
				M=N;
				N=tempM1;
				

				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(rotate1[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			case 5:
				temp = new LinkedList();//임시로 계속 객체 다시 받음
				temp2 = new LinkedList();
				for(int r = 0;r<N/2;r++) {//1사분면
					for(int c = 0; c<M/2;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int r = 0;r<N/2;r++) {//2사분면
					for(int c = M/2; c<M;c++) {
						temp2.add(arr[r][c]);
					}
				}
				for(int r = 0;r<N/2;r++) {//1사분면 넣음 ->2
					for(int c = M/2; c<M;c++) {
						arr[r][c] = temp.poll();
					}
				}
				for(int r = N/2;r<N;r++) {//3사분면 ->1
					for(int c = 0; c<M/2;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int r = 0;r<N/2;r++) {// 3 -> 1사분면
					for(int c = 0; c<M/2;c++) {
						arr[r][c] = temp.poll();
					}
				}
				for(int r = N/2;r<N;r++) {//4사분면
					for(int c = M/2; c<M;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int r = N/2;r<N;r++) {//4사분면 ->3
					for(int c = 0; c<M/2;c++) {
						arr[r][c] = temp.poll();
					}
				}
				for(int r = N/2;r<N;r++) {//2사분면 넣음 ->4
					for(int c = M/2; c<M;c++) {
						arr[r][c] = temp2.poll();
					}
				}
				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(arr[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			case 6:
				temp = new LinkedList();//임시로 계속 객체 다시 받음
				temp2 = new LinkedList();
				for(int r = 0;r<N/2;r++) {//1
					for(int c = 0; c<M/2;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int r = N/2;r<N;r++) {//4
					for(int c = 0; c<M/2;c++) {
						temp2.add(arr[r][c]);
					}
				}
				for(int r = N/2;r<N;r++) {//1->4
					for(int c = 0; c<M/2;c++) {
						arr[r][c] = temp.poll();
					}
				}
				for(int r = N/2;r<N;r++) {//3
					for(int c = M/2; c<M;c++) {
						temp.add(arr[r][c]);
					}
				}
				for(int r = N/2;r<N;r++) {//4 -> 3
					for(int c = M/2; c<M;c++) {
						arr[r][c] = temp2.poll();
					}
				}
				for(int r = 0;r<N/2;r++) {//2
					for(int c = M/2; c<M;c++) {
						temp2.add(arr[r][c]);
					}
				}
				for(int r = 0;r<N/2;r++) {//3->2
					for(int c = M/2; c<M;c++) {
						arr[r][c] = temp.poll();
					}
				}
				for(int r = 0;r<N/2;r++) {//1
					for(int c = 0; c<M/2;c++) {
						arr[r][c] = temp2.poll();
					}
				}
				if(i == mod-1) {
				for(int i1 = 0; i1<N;i1++) {
					for(int j = 0;j<M;j++) {
						System.out.print(arr[i1][j]+" ");
					}System.out.println();
				}
				}
				break;
			}
			
		}
		
		
	}
}
