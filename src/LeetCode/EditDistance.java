package LeetCode;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(e.minDistance(word1, word2)); // Should return 5
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 초기값
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        // 점화식 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
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

        return dp[m][n];
    }
}
