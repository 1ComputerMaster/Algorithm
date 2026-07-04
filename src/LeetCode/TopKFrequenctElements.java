package LeetCode;

import java.util.*;


public class TopKFrequenctElements {
    public static void main(String[] args) {
        TopKFrequenctElements topKFrequenctElements = new TopKFrequenctElements();
        System.out.println(Arrays.toString(topKFrequenctElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pq.offer(entry);

            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
