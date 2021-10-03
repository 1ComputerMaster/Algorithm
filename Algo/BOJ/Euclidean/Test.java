package Euclidean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int a = Integer.parseInt(tk.nextToken()); 
		int b = Integer.parseInt(tk.nextToken()); 
		System.out.println(gcd(a,b));
		System.out.println((a*b)/gcd(a,b));
	}
	public static int gcd(int p, int q)
	 {
		if (q == 0) return p;
		return gcd(q, p%q);
	 }
}
