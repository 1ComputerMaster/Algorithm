package LeetCode;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int idx = (c - 'a');
            alpha[idx] += 1;
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int idx = (c - 'a');
            if(alpha[idx] <= 0){
                return false;
            }
            alpha[idx] -= 1;
        }
        return true;
    }

}
