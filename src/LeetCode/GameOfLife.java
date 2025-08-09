package LeetCode;

public class GameOfLife {
    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        gol.gameOfLife(board);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    int[] dx = {-1,-1,-1,0,0,1,1,1};
    int[] dy = {-1,0,1,-1,1,-1,0,1};
    public void gameOfLife(int[][] board) {
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                int cnt = 0;
                for(int d = 0; d < 8; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx >= 0 && ny >= 0 && ny < board[0].length && nx < board.length && Math.abs(board[nx][ny]) == 1){
                        cnt++;
                    }
                }
                if(cnt == 3 && board[x][y] == 0){
                    board[x][y] = 2;
                }
                if(cnt > 3 && board[x][y] == 1){
                    board[x][y] = -1;
                }
                if(cnt < 2 && board[x][y] == 1){
                    board[x][y] = -1;
                }
                if((cnt == 3 || cnt == 2) && board[x][y] == 1){
                    board[x][y] = 1;
                }
            }
        }
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(board[x][y] == 2){
                    board[x][y] = 1;
                }
                if(board[x][y] == -1){
                    board[x][y] = 0;
                }
            }
        }
    }
}
