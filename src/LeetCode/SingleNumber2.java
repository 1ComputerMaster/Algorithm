package LeetCode;

public class SingleNumber2 {
    public static void main(String[] args) {
        SingleNumber2 s = new SingleNumber2();
        int[] nums = {1525, 1332, 1525, 1525};
        System.out.println(s.singleNumber(nums)); // Should return 3
    }
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }

        return ones;
    }
}
