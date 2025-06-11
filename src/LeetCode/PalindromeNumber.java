package LeetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10000_3_0001)); // Example usage
    }
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length() - 1;
        int i = 0;
        while(i <= len / 2){
            if(str.charAt(i) != str.charAt(len - i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
