package LeetCode;

public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour p = new PowerOfFour();
        int n = 16;
        System.out.println(p.isPowerOfFour(n)); // Should return true
    }
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
