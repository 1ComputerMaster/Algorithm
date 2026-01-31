package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictonary {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        AlienDictonary ad = new AlienDictonary();
        String order = ad.findOrder(words);
        System.out.print(order);
    }

    public String findOrder(String[] words) {
        List<Integer> graph[] = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        // In-degree of each character
        int[] inDegree = new int[26];
        boolean[] isPresent = new boolean[26];
        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    graph[c1 - 'a'].add(c2 - 'a');
                    inDegree[c2 - 'a']++;
                    isPresent[c1 - 'a'] = true;
                    isPresent[c2 - 'a'] = true;
                    break;
                }
            }
        }

        // Topological Sort
        StringBuilder order = new StringBuilder();
        Queue<Integer> zeroInDegree = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (isPresent[i] && inDegree[i] == 0) {
                zeroInDegree.add(i);
            }
        }

        while (!zeroInDegree.isEmpty()) {
            int curr = zeroInDegree.poll();
            order.append((char) (curr + 'a'));
            for (int neighbor : graph[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    zeroInDegree.add(neighbor);
                }
            }
        }
        // Check for cycles
        for (int degree : inDegree) {
            if (degree > 0) {
                return "";
            }
        }
        return order.toString();
    }
}
