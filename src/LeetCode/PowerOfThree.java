package LeetCode;

public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree p = new PowerOfThree();
        int n = 27;
        System.out.println(p.isPowerOfThree(n)); // Should return true
    }
    public boolean isPowerOfThree(int n) {
        boolean check = false;
        if(n == 1) return true;
        if(n < 3){
            return false;
        }
        if(n == 3){
            return true;
        }
        if(n % 3 == 0){
            check = isPowerOfThree(n / 3);
        }
        return check;
    }
}
