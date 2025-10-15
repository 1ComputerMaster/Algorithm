package LeetCode;

public class FactorialTrailingZeros {
    public static void main(String[] args) {
        FactorialTrailingZeros f = new FactorialTrailingZeros();
        int n = 5;
        System.out.println(f.trailingZeroes(n));
    }
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n >= 5){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
