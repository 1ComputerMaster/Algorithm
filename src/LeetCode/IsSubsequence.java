package LeetCode;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

    }
    public static boolean isSubsequence(String s, String t) {
        int maxIdx = 0;
        for(int i = 0; i < s.length(); i++){
            if(t.indexOf(s.charAt(i)) == -1){
                return false;
            }else{
                maxIdx = t.indexOf(s.charAt(i));
                t = t.substring(maxIdx + 1, t.length());
            }
        }
        return true;
    }
}
