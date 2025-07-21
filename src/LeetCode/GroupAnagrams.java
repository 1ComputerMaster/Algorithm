package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result); // Output: [[bat], [nat, tan], [ate, eat, tea]]
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for(String str : strs){
            char[] crr = str.toCharArray();
            Arrays.sort(crr);
            String key = new String(crr);

            if(!anagram.containsKey(key)){
                anagram.put(key, new ArrayList());
            }
            anagram.get(key).add(str);
        }
        return new ArrayList<>(anagram.values());
    }
}
