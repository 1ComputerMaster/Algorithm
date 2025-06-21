package LeetCode;
import java.util.*;

public class FindFirstAndLastPos {
    static List<Integer> ans;

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        ans = new ArrayList();
        binarySearch(right, left, nums, target);
        if(ans.size() > 0){
            Collections.sort(ans);
            if(ans.size() == 1){
                int[] arr = new int[2];
                arr[0] = ans.get(0);
                arr[1] = ans.get(0);
                return arr;
            }
            int[] arr = new int[2];
            int i = 0;
            int max = Collections.max(ans);
            int min = Collections.min(ans);

            arr[0] = min;
            arr[1] = max;
            return arr;
        }else{
            return new int[] {-1, -1};
        }
    }
    private static void binarySearch(int right, int left, int[] nums, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                ans.add(mid);
                binarySearch(mid - 1, left, nums, target);
                binarySearch(right, mid + 1, nums, target);
                return;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
    }
}