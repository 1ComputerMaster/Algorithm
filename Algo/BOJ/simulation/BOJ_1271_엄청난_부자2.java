package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1271_엄청난_부자2 {
	/*
	 * Big Integer로 10000000000... 이상의 값을 처리 할 수 있다.
	 * 
	 * */

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		BigInteger n = new BigInteger(tk.nextToken());
		BigInteger m = new BigInteger(tk.nextToken());
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
		
	}

}
