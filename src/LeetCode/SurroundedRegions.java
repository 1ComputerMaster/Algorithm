package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);
        for (char[] row : board) {
            System.out.println(row);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void solve(char[][] board) {
        //O 인 곳을 start 끊고 visited 방문처리 체크해야함
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    char[][] region = new char[n][m];
                    boolean isItOkay = BFS(region, board, i, j);
                    if(isItOkay){
                        mapToMap(region, board);
                    }
                }
            }
        }

    }

    //refresh용 맵
    //refresh용 맵이 BFS 한 번 돌 때마다 초기화 되어야 함
    //만일 끝 지점이랑 맞닿은 곳이 있는 region이면 그건 Skip
    private static boolean BFS(char[][] region, char[][] board, int startX, int startY){
        int n = board.length;
        int m = board[0].length;
        boolean [][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == 0 || y == 0 || x == n - 1 || y == m - 1){
                return false;
            }

            visited[x][y] = true;
            region[x][y] = 'X';
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < n && ny < m && ny >= 0 && !visited[nx][ny] && board[nx][ny] == 'O'){
                    if(nx == 0 || ny == 0 || ny == m - 1 || nx == n - 1){
                        return false;
                    }
                    visited[nx][ny] = true;
                    region[nx][ny] = 'X';
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return true;
    }


    //region 맵 덮어 씌우기 용 메서드 제작
    private static void mapToMap (char[][] src, char[][] dest){
        for(int i = 0; i < src.length; i++){
            for(int j = 0; j < src[0].length; j++){
                if(dest[i][j] == 'O' && src[i][j] == 'X'){
                    dest[i][j] = src[i][j];
                }
            }
        }
    }
}