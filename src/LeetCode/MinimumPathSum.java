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
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = grid[i][j];
            }
        }

        for(int i = 1; i < grid.length; i++){
            dp[i][0] += dp[i - 1][0];
        }

        for(int j = 1; j < grid[0].length; j++){
            dp[0][j] += dp[0][j - 1];
        }


        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
