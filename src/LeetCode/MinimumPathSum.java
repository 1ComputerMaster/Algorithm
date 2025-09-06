package LeetCode;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(m.minPathSum(grid)); // Should return 7
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i - 1 != 0 && j - 1 != 0){
                    dp[i][j] = Math.min(grid[i - 1][j - 1] + dp[i - 1][j], grid[i - 1][j - 1] + dp[i][j - 1]);
                }
                if(i - 1 == 0){
                    dp[i][j] = grid[i - 1][j - 1] + dp[i][j - 1];
                }
                if(j - 1 == 0){
                    dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
