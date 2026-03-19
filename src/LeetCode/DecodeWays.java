package LeetCode;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "226";
        int result = d.numDecodings(s);
        System.out.println(result); // Should print 3
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(s.charAt(0) != '0'){
            dp[1] = 1;
        }
        for(int i = 2; i <= n; i++){
            String str = s.substring(i - 2, i);
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26){
                dp[i] += dp[i - 2];
            }
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }
}
