package LeetCode;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        int num = 16; // Example input
        System.out.println(vps.isPerfectSquare(num)); // Should return true for 16
    }
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        for(long i = 1; i <= (num / 2); i++){
            if(i * i > num){
                return false;
            }else if (i * i == num){
                return true;
            }
        }
        return false;
    }
}
