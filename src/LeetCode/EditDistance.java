package LeetCode;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(e.minDistance(word1, word2)); // Should return 5
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; //이전 상태 전이...
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j], // 삭제
                            Math.min(
                                    dp[i][j - 1], // 삽입
                                    dp[i - 1][j - 1] // 교체
                            )
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
