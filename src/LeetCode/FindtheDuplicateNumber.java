package LeetCode;

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber f = new FindtheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(f.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) { //Binary Search on value based
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (mid >= num) {
                    cnt++;
                }
            }
            if (cnt > mid) { //중복 값이라면 자신의 숫자 보다 더 큰 갯수가 있다.
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
