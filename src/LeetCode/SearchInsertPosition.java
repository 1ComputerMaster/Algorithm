package LeetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(sol.searchInsert(nums, target));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return left;
    }
}
