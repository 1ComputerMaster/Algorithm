package LeetCode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645)); // Example usage
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1; // Check the least significant bit
            n >>>= 1; // Right shift n by 1 (unsigned)
        }
        return count;
    }

}
