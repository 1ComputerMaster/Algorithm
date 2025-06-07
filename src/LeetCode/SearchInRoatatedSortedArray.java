package LeetCode;

public class SearchInRoatatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    /**
     * 
     * @param nums
     * @param target
     * @apiNote 
     * 1. 특정 파트의 오름 차순을 탐색하고 이를 찾아낸다.  <br/>
     * 2. nums[L] < nums[M] 인경우 이 사이는 모두 오름차순임  <br/>
     * 3. 위 조건을 만족하지 못한 레이어의 반대는 [M] - [R] 인데 한쪽이 만족하지 못하면 다른 한쪽이 모두 오름차순임  <br/>
     * 4. 나머지는 해당 레이어 사이에 target이 있는지 탐색하는 조건을 통해서 찾는다.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // 오름차순 레이어
            if(nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 오름차순 레이어
            else{
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
