package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // Example usage
    }
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((o1,  o2) -> o2 - o1);
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < k; i++){
            ans = pq.poll();
        }
        return ans;
    }
}
