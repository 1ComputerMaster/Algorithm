package simulation;

import java.io.*;
import java.util.*;

public class BOJ_2615_오목 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		// 구현하세요.
		char check[][] = new char[21][21];
		String str;
		int dx[] = {1,1,0,-1};
		int dy[] = {0,1,1,1};
		boolean ok = false;
		for(int i = 1;i<=19;i++)
		{
			for(int j = 1;j<=19;j++)
			{
				check[i][j]=sc.next().charAt(0);
			}
		}
		
		for(int j = 1;j<=19;j++)
		{
			for(int i = 1;i<=19;i++)
			{
				if(check[i][j] == 1+'0') {//1번
					for(int d = 0;d<4;d++) {
						int nx = i+dx[d];//2번
						int ny = j+dy[d];
						if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19  && check[nx][ny] == 1+'0') {
							nx+=dx[d];//3번
							ny+=dy[d];
							if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19  && check[nx][ny] == 1+'0') {
								nx+=dx[d];//4번
								ny+=dy[d];
								if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19  && check[nx][ny] == 1+'0') {
									nx+=dx[d];//5번
									ny+=dy[d];
									if(nx < 1 ||ny < 1 && nx > 19 && ny > 19) {
										continue;
									}
									if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19  && check[nx][ny] == 1+'0') {
										nx+=dx[d];//19
										ny+=dy[d];
										if(check[nx][ny] == 1+'0') {
											check[nx][ny] = '3';
											continue;
										}
										if(check[nx][ny]=='3')
											continue;
										if(nx >= 0 && ny >= 0 && nx <= 20 && ny <= 20 && check[nx][ny] != 1+'0' && check[nx][ny] !='3') {
											System.out.println(1);
											System.out.println((i) +" "+ (j));
											return;
											}
									}
								}
							}
							
						}
						
					}
				}
				if(check[i][j] == 2+'0') {
					for(int d = 0;d<4;d++) {
						int nx = i+dx[d];
						int ny = j+dy[d]; //1번
						if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19 && check[nx][ny] == 2+'0') {
							nx+=dx[d];
							ny+=dy[d]; // 2번
							if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19 && check[nx][ny] == 2+'0') {
								nx+=dx[d];
								ny+=dy[d]; //3번
								if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19 && check[nx][ny] == 2+'0') {
									nx+=dx[d];
									ny+=dy[d]; //4번
									if(nx < 1 ||ny < 1 && nx > 19 && ny > 19) {
										continue;
									}
									if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19 && check[nx][ny] == 2+'0') {
										nx+=dx[d];
										ny+=dy[d]; //4번
										if(check[nx][ny] == 2+'0') {
											check[nx][ny] = '3';
										}
										if(check[nx][ny]=='3')
											continue;
										if(nx >= 0 && ny >= 0 && nx <= 20 && ny <= 20 && check[nx][ny] != 2+'0'&& check[nx][ny] !='3' ) {
											System.out.println(2);
											System.out.println((i) +" "+ (j));
											return;
											}
									}
								}
							}
							
						}
						
					}
				}
			}
		}
		System.out.println(0);
		/*if(ok == false)
		{System.out.println(0);}*/
	/*	for(int i = 0;i<8;i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < 19 && ny < 19) {
				if(check[nx][ny] == 1) {
						for(int k = 0;k<3;k++) {
							
						}
				}
			}
		}*/
		sc.close();
	}

}
