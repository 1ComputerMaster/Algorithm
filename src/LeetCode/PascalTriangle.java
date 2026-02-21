package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println(result); // Should print the first 5 rows of Pascal's Triangle
    }
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        for(int i = 1; i < numRows; i++){
            dp[i][0] = 1;
            if(i > 1){
                for(int j = 1; j < i; j++){
                    dp[i][j] += dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            dp[i][i] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList();
            for(int j = 0; j <= i; j++){
                list.add(dp[i][j]);
            }
            ans.add(new ArrayList(list));
        }
        return ans;
    }

}
