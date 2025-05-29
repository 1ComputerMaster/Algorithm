package LeetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;        // 찾았으면 그 인덱스 반환
            } else if (nums[mid] < target) {
                left = mid + 1;    // target 이 더 크면 오른쪽 절반 탐색
            } else {
                right = mid - 1;   // target 이 더 작으면 왼쪽 절반 탐색
            }
        }
        return left;
    }

}
