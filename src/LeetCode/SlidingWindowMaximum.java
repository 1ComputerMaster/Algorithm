package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = nums.length - k + 1;
        int[] arr = new int[m];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            // 1. 현재 윈도우 범위를 지나간 index는 제거
            while(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }

            // 2. 현재 윈도우 범위이나 내 현재 인덱스 값 안에 저장된 것 보다 작거나 같은 것은 flush
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            // 3. 현재 인덱스 위치를 deque 뒷쪽에 넣음
            deque.offerLast(i);

            // 4. 윈도우가 완성되면 result 배열의 max 값을 넣음
            if(i - k + 1 >= 0){
                arr[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return arr;
    }
}
