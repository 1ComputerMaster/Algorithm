package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1297_TV크기 {
/*
 * 그냥 공식 써서 구하는 구현 문제
 * 
 * */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int D = Integer.parseInt(tk.nextToken());
		int H = Integer.parseInt(tk.nextToken());
		int W = Integer.parseInt(tk.nextToken());
		double res = Math.sqrt(Math.pow(D, 2)/(Math.pow(H, 2) + Math.pow(W, 2)));
		System.out.println((int)Math.floor(res*H) + " "+ (int)Math.floor(res*W));
	}

}
