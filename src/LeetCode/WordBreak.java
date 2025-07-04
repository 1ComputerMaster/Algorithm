package LeetCode;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", List.of(new String[]{"cats", "dog", "sand", "and", "cat"}))); // Example usage
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (String word : wordDict) {
                if (i >= word.length()
                    && dp[i - word.length()]
                    && s.startsWith(word, i - word.length())){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
