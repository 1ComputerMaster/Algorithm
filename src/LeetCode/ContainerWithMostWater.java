package LeetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height)); // Output: 49
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            maxArea = Math.max(maxArea, (Math.min(height[left], height[right]) * (right - left)));
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
