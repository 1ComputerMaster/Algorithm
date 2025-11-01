package LeetCode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
    * bounded 함수를 통해 이진 탐색으로 타겟의 가장 왼쪽과 가장 오른쪽 인덱스를 찾는다.
    * 1. bounded 함수는 isBigger 플래그를 통해 가장 왼쪽 인덱스와 가장 오른쪽 인덱스를 구분한다.
    * 2. isBigger이 true일 경우, 타겟과 일치하는 값을 찾았을 때 오른쪽으로 탐색을 계속 진행하여 가장 큰 인덱스를 찾는다.
    * 3. isBigger이 false일 경우, 타겟과 일치하는 값을 찾았을 때 왼쪽으로 탐색을 계속 진행하여 가장 작은 인덱스를 찾는다.
    * 4. searchRange 함수에서 bounded 함수를 두 번 호출하여 가장 왼쪽과 가장 오른쪽 인덱스를 구한다.
    * 5. 만약 타겟이 배열에 존재하지 않을 경우, -1, -1을 반환한다.
    * 6. 시간 복잡도 : O(log n)
    * 7. 공간 복잡도 : O(1)
    * */
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FindFirstAndLastPositionOfElementInSortedArray sol = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] ans = sol.searchRange(nums, target);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int right = bounded(0, nums.length, target, nums, true);
        int left = bounded(0, nums.length, target, nums, false);

        if(right != -1 || left != -1){
            if(left == -1){
                return new int[]{right, right};
            }
            if(right == -1){
                return new int[]{left, left};
            }
        }
        return new int[]{left, right};
    }


    private int bounded(int left, int right, int target, int[] nums, boolean isBigger){
        int ans = 0;

        if(isBigger){
            ans = Integer.MIN_VALUE;
        }else{
            ans = Integer.MAX_VALUE;
        }

        boolean check = false;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid < nums.length && nums[mid] == target){
                if(isBigger){
                    ans = Math.max(mid, ans);
                    left = mid + 1;
                }else{
                    ans = Math.min(mid, ans);
                    right = mid - 1;
                }
                check = true;
            }else{
                if(mid < nums.length && nums[mid] < target ){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        if(check)
        {
            return ans;
        }else{
            return -1;
        }
    }
}
