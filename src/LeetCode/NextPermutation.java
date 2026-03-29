package LeetCode;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1,2,4,3};
        n.nextPermutation(nums);
        for(int x : nums){
            System.out.print(x + " ");
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int prev = nums[n - 1]; //3
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--){
            if(prev > nums[i]){ // 2 감소 구간임
                change(nums, i);
                pivot = i;
                break;
            }
            prev = nums[i];
        }
        reverse(nums, pivot + 1, nums.length - 1);
    }
    private void change(int[] arr, int pivot) {
        int tmp = arr[pivot];
        for (int i = arr.length - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                arr[pivot] = arr[i];
                arr[i] = tmp;
                break;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
