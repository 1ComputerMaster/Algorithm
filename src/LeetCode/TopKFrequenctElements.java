package LeetCode;

import java.util.*;


public class TopKFrequenctElements {
    public static void main(String[] args) {
        TopKFrequenctElements topKFrequenctElements = new TopKFrequenctElements();
        System.out.println(Arrays.toString(topKFrequenctElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++){
            ans[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return ans;
    }
}
