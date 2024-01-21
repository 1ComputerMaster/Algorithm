package Programmers.Euclidean;

public class Pro_멀쩡한_사각형 {
	public long solution(int w, int h) {
		long answer = 1;
		long wl = Integer.parseInt(String.valueOf(w));
		long hl = Integer.parseInt(String.valueOf(h));
		if(wl > hl) {
			answer = (wl*hl)-(wl+hl-gcd(wl,hl));
		}else {
			answer = (wl*hl)-(wl+hl-gcd(hl,wl));
		}
		return answer;
	}
	private static long gcd(long m,long n){
		while(n > 0) {
			long temp = m%n;
			m = n;
			n = temp;
		}
		return m;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
