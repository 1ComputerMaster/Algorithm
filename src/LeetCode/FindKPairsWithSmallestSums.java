package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        FindKPairsWithSmallestSums solution = new FindKPairsWithSmallestSums();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result); // Expected output: [[1, 2], [1, 4], [1, 6]]

    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0}); // Store the index of nums2 as well
        }
        // 메모리 최적화를 위해서 2번 Array 배열은
        // 1번 배열으로 모두 초기화 된 후 필요한 만큼만 꺼내쓴다.
        // 최초에는 [1,2] 만 저장이 되고 다음 스탭 일 때
        // [1,4] 가 저장되는 형태이다.
        // 그리고, 이 때 이미 nums1[]은 모두 그 전에 저장 시켜 두었으니 k개 만큼만 최소한의 nums2 값만 가져와서 sum을 검증한다.
        // 이렇게 풀지 않으면 TC 중 k가 10000일 경우 Memory Optimization이 되지 않아 Failed 처리 된다.
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            result.add(List.of(current[0], current[1]));
            // If there is a next element in nums2, add the new pair to the heap
            if (current[2] + 1 < nums2.length) {
                minHeap.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
            }
        }

        return result;
    }
}
