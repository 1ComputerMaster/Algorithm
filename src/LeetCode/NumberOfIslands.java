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

    static boolean[][] visited;
    public static int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static void bfs(char[][] grid, int x, int y){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || grid[nx][ny] != '1'){
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return;
    }
}
