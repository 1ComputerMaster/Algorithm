package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths2 {
    public static void main(String[] args) {
        UniquePaths2 sol = new UniquePaths2();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
    }
    int[] dx = {1,0};
    int[] dy = {0,1};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0});
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) {
            return 0;
        }

        boolean[][] visited = new boolean[n][m];
        int[][] count = new int[n][m];
        visited[0][0] = true;
        count[0][0] = 1;

        while(!q.isEmpty()){
            int[] where = q.poll();
            int x = where[0];
            int y = where[1];
            for(int d = 0; d < 2; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && obstacleGrid[nx][ny] != 1){
                    count[nx][ny] += count[x][y];
                    if(!visited[nx][ny]){
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count[n - 1][m - 1];
    }
}

