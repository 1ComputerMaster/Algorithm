package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> keyMap = new HashMap<>();
        Map<String, Character> valueMap = new HashMap<>();
        String[] str = s.split(" ");

        if(str.length != pattern.length()){
            return false;
        }

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(!keyMap.containsKey(c)){
                keyMap.put(c, str[i]);
            }else{
                if(!str[i].equals(keyMap.get(c))){
                    return false;
                }
            }
            if(!valueMap.containsKey(str[i])){
                valueMap.put(str[i], c);
            }else{
                if(c != valueMap.get(str[i])){
                    return false;
                }
            }
        }
        return true;
    }

}
