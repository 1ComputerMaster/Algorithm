package LeetCode;

public class SortColors {
    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        for(int x : nums){
            System.out.print(x + " ");
        }
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = i; j < n; j++){
                if(nums[j] == 0){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] == 1 || nums[i] == 0){
                continue;
            }
            for(int j = i; j < n; j++){
                if(nums[j] == 1){
                    nums[j] = nums[i];
                    nums[i] = 1;
                }
            }
        }
    }
}
