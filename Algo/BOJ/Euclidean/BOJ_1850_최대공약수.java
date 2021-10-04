package Euclidean;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_1850_최대공약수 {
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		Scanner sc = new Scanner(System.in);
		long f = sc.nextLong();
		long t = sc.nextLong();
		long temp = Math.abs(GCD(f,t));
		for (long i = 0; i < temp; i++) {
            bw.write("1");//출력	
        }
    bw.flush();//남아있는 데이터를 모두 출력시킴
    bw.close();//스트림을 닫음

	}
	private static long GCD(long m,long n) {
		long temp = 0;
		while(n > 0) {
			temp = m%n;
			m = n;
			n = temp;
		}
		return m;
	}
}