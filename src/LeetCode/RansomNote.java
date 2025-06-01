package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            char s = magazine.charAt(i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++){
            if(map.getOrDefault(ransomNote.charAt(i), 0) == 0){
                return false;
            }
            map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);

        }
        return true;
    }
}
