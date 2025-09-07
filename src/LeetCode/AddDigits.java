package LeetCode;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        int num = 38;
        System.out.println(solution.addDigits(num)); // Output: 2
    }
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
