package LeetCode;

import java.util.*;


public class TopKFrequenctElements {
    public static void main(String[] args) {
        TopKFrequenctElements topKFrequenctElements = new TopKFrequenctElements();
        System.out.println(Arrays.toString(topKFrequenctElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pq.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(k-- > 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
