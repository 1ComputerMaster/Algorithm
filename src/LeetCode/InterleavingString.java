package LeetCode;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1, s2, s3)); // Should return true
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        if((n + m) != s3.length()){
            return false;
        }

        for(int j = 1; j <= m; j++){
            dp[0][j] = dp[0][j-1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for(int i = 1; i <= n; i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n][m];
    }

}
