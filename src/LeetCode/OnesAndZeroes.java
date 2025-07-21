package LeetCode;

public class OnesAndZeroes {
    public static void main(String[] args) {
        OnesAndZeroes solution = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(solution.findMaxForm(strs, m, n)); // Output: 4
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str: strs){
            char[] crr = str.toCharArray();
            int one = 0;
            int zero = 0;
            for(int i = 0; i < crr.length; i++){
                if(crr[i] == '0'){
                    zero++;
                }
                else{
                    one++;
                }
            }
            // zero, one 이 아예 커버리면 skip
            for(int i = m; i >= zero; i--){
                for(int j = n; j >= one; j--){
                    //이전 상태의 것을 전이 시켜서 가져온다.
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zero][j - one]);
                }
            }
        }
        return dp[m][n];
    }
}
