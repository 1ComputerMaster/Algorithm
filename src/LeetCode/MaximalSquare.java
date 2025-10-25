package LeetCode;

/**
 * LeetCode 221. Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * @author khw5653
 * 300 * 300 matrix라서 O(n^2) 알고리즘으로 끝내야 하므로 DP로 접근한다.
 * 접근 방식 : DP 배열은 현재 내 위치가 사각형의 오른쪽 꼭지점이라고 생각한다.
 * 1. DP 배열 초기화 : matrix의 값이 '1'인 곳에 1을 넣어준다.
 * 2. 점화식 : dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 *   - dp[i-1][j] : 위쪽 정사각형
 *   - dp[i][j-1] : 왼쪽 정사각형
 *   - dp[i-1][j-1] : 대각선(↖) 정사각형
 *   -> 이 세 값 중 최소값에 1을 더해주면 현재 위치에서 만들 수 있는 가장 큰 정사각형의 한 변의 길이가 된다.
 *     -> 최소값으로 지정한 이유는 만일, 하나라도 0이 포함되어 있다면 그 위치에서는 사각형을 더이상 제작 할 수 없기 때문이다.
 *   3. 최종 답안 도출 : DP 배열을 순회하며 가장 큰 값을 찾아 제곱하여 반환한다.
 *   시간 복잡도 : O(n*m)
 *   공간 복잡도 : O(n*m)
 */

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        MaximalSquare sol = new MaximalSquare();
        int ans = sol.maximalSquare(matrix);
        System.out.println(ans);
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1')
                {
                    dp[i][j] = 1;
                }
            }
        }


        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(
                            dp[i-1][j],       // 위쪽 정사각형
                            Math.min(dp[i][j - 1],       // 왼쪽 정사각형
                                    dp[i-1][j-1])      // 대각선(↖) 정사각형
                    ) + 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dp[i][j]*dp[i][j]);
            }
        }
        return ans;
    }
}
