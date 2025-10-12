package LeetCode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        String ans = sol.longestPalindrome(s);
        System.out.println(ans);
    }
    /*
    * Runtime: 1670ms, Beats 10.86%
    * Memory: 44.82MB, Beats 44.20%
    * 삼중 for문으로 브루트 포스로 찾을 시 매우 느림
    * */
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            char start = s.charAt(i);
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == start){
                    int endIdx = j;
                    int startIdx = i;
                    while(s.charAt(endIdx) == s.charAt(startIdx)){
                        if(startIdx >= endIdx){
                            break;
                        }
                        endIdx--;
                        startIdx++;
                    }
                    if(startIdx >= endIdx){
                        if(max <= (j - i)){
                            ans = s.substring(i, j + 1);
                            max = j - i;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
