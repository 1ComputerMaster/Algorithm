package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2448_별찍기11 {
	static char d[][];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		d = new char[3*1024+1][6*1024+1];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {// 3*2^n
			for (int j = 0; j < 2*N; j++) { // 6*2^n
				if(j == 2*N-1) { // 끝까지 오면 개행
					d[i][j]='\n';
				}else {
					d[i][j]=' ';
				}
			}
		}
		star(N,0,N-1); //삼각형의 높이, N-1은 삼각형을 나누었을때 6*3*2^n의 반이니깐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N -1; j++) {
				sb.append(d[i][j]);
			}sb.append("\n");
		}System.out.print(sb);
	}
	private static void star(int height, int x,int y) {
		if(height == 3) { // 더이상 쪼갤 수 없는 삼각형이 된다면..
			d[x][y] = '*';
			d[x + 1][y - 1] = '*'; // x가 y축 처럼 내려감
			d[x + 1][y + 1] = '*';
			d[x + 2][y - 2] = '*';
			d[x + 2][y - 1] = '*';
			d[x + 2][y] = '*';
			d[x + 2][y + 1] = '*';
			d[x + 2][y + 2] = '*';
			return;
		}
		star(height/2,x,y); //맨 위쪽 삼각형 기존의 중간 위치서 부터 시작
		star(height/2,x + (height/2),y - (height/2)); // 왼쪽 하단 삼각형  x + 가 내려가는 것
		star(height/2,x + (height/2),y + (height/2)); // 오른쪽으로 하단 삼각형 y + 하여서 우측으로 더 이동
	}
}
