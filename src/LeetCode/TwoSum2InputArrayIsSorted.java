package LeetCode;

public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: Indices: 1, 2
    }
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[] {left + 1, right + 1};
            }
            if(sum > target){
                right--;
            }
            if(sum < target){
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
