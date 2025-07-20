package LeetCode;

public class PowX_N {
    public static void main(String[] args) {
        PowX_N powX_n = new PowX_N();
        double x = 2.0;
        int n = 10;
        System.out.println(powX_n.myPow(x, n)); // Should return 1024.0
    }
    public double myPow(double x, int n) {
        long exp = n;           // int 최솟값 처리 위험 회피
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        double result = 1.0;

        // exp의 각 비트마다
        while (exp > 0) {
            // 하위 비트가 1이면, 현재 x^power 를 결과에 곱하고
            if ((exp & 1) == 1) {
                result *= x;
            }
            // x^power → x^(power*2)
            x *= x;
            // 지수를 오른쪽으로 한 비트 시프트
            exp >>= 1;
        }
        return result;
    }

}
