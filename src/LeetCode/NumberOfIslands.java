package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    public static void main(String[] args) {
        char[][] grid =
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                };
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    cnt++;
                    BFS(i, j, visited, grid);
                }
            }
        }
        return cnt;
    }

    private static void BFS(int startX, int startY, boolean[][] visited, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < n && ny < m && ny >= 0 && nx >= 0 && !visited[nx][ny] && grid[nx][ny] == '1'){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
