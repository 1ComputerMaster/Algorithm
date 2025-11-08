package LeetCode;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
        int[] nums = {7,8,9,0,1,3,4,5};
        int ans = sol.findMin(nums);
        System.out.println(ans);
    }
    /*
    * 단순히 min 값을 찾는 것이라서 mid 부터 right까지만 ascending 되어 있는지 확인하고
    * 아니라면 left를 mid + 1로 옮겨주는 방식으로 진행하면 쉽게 풀 수 있다. (min 값이 mid에 있을 수 없으므로 mid를 포함하지 않는 left = mid + 1로 설정)
    * 맞을 경우 right를 mid로 옮겨서 탐색 범위를 좁힌다. (그곳에 min이 있을 수 있으므로)
    * 아래 코드도 O(log n)으로 동작하지만 불필요한 조건문이 많아 비효율적이다.
    * Debugging을 통해서 테스트 케이스의 답변에 따라 조건문을 수정하다보니 아래와 같이 비효율적인 코드가 들어갔다.
    * 좀 더 생각하고 깔끔하게 짤 수 있는 능력을 키워야 한다.
    * */
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int before = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(min == nums[mid]){
                break;
            }
            min = Math.min(nums[mid], min);
            if(before == nums[mid]){
                break;
            }
            before = nums[mid];
            if(nums[left] >= nums[mid] && nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[left] < nums[mid] && nums[mid] < nums[right]){
                right = mid - 1;
            }
            else if(nums[left] < nums[mid] && nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[left] > nums[mid] && nums[mid] <= nums[right]){
                right = mid - 1;
            }
        }
        return min;
    }
}
