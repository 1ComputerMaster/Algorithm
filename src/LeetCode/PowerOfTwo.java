package LeetCode;

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        int n = 16;
        System.out.println(p.isPowerOfTwo(n)); // Should return true
    }
    public boolean isPowerOfTwo(int n) {
        int num = 1;
        for (int i = 1; i <= 31; i++) {
            if(n == num) return true;
            num *= 2;
        }
        return false;
    }
}
