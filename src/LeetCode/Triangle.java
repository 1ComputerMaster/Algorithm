package LeetCode;

import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        System.out.println(t.minimumTotal(triangle)); // Should return 11
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] : i행 j열 위치까지 왔을 때 최소 합
        int[][] dp = new int[n][n];

        // 0행 0열 초기화
        dp[0][0] = triangle.get(0).get(0);

        // 각 행 i
        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);
            int m = row.size();
            // 그 행의 첫 번째 열(j=0)은 위 행의 첫 칸에서만 올 수 있음
            dp[i][0] = dp[i-1][0] + row.get(0);
            // 그 행의 마지막 열(j=i)는 위 행의 마지막 칸에서만 올 수 있음
            dp[i][i] = dp[i-1][i-1] + row.get(i);
            // 나머지 칸(j=1…i-1)은 두 방향에서 올 수 있음
            for (int j = 1; j < i; j++) {
                int val = row.get(j);
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + val;
            }
        }

        // 마지막 행에서 최소값 찾기
        int res = dp[n-1][0];
        for (int j = 1; j < n; j++) {
            res = Math.min(res, dp[n-1][j]);
        }
        return res;
    }

}
