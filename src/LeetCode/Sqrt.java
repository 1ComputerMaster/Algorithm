package LeetCode;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8)); // Example usage
    }
    public static int mySqrt(int x) {
        if (x < 2) return x; // Handle cases for 0 and 1 directly
        int left = 2, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Use long to prevent overflow
            if (square == x) {
                return mid; // Found exact square root
            } else if (square < x) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }
        return right; // The largest integer whose square is less than or equal to x
    }
}
