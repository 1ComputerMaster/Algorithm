package LeetCode;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCB";
        System.out.println(ws.exist(board, word)); // true
    }
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int n,m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        if(n == 1 && m == 1 && word.length() == 1 && word.charAt(0) != board[0][0]){
            return false;
        }
        boolean[][] visited;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited = new boolean[n][m];
                if(board[i][j] != word.charAt(0)){
                    continue;
                }
                visited[i][j] = true;
                if(dfs(i, j, visited, 1, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, boolean[][] visited, int wordCnt, String word, char[][] board){
        if(word.length() == wordCnt){
            return true;
        }else{
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= n || ny >= m || nx < 0 || ny < 0){
                    continue;
                }
                if(!visited[nx][ny] && word.charAt(wordCnt) == board[nx][ny]){
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, visited, wordCnt + 1, word, board)){
                        return true;
                    }
                    visited[nx][ny] = false;
                }
            }
        }
        return false;
    }


//    public boolean exist(char[][] board, String word) {
//        int n = board.length;
//        int m = board[0].length;
//        // word를 char[]로 변환 (원하시는 대로 int[]로 바꿔도 무방)
//        char[] wArr = word.toCharArray();
//
//        boolean[][] visited = new boolean[n][m];
//        // 시작점 후보 모두 시도
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == wArr[0]) {
//                    // 첫 글자부터 맞으면 DFS 진입
//                    visited[i][j] = true;
//                    if (dfs(board, wArr, visited, i, j, 1)) {
//                        return true;
//                    }
//                    visited[i][j] = false;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * @param board 보드
//     * @param wArr  찾을 단어의 char 배열
//     * @param visited 방문 표시
//     * @param x     현재 위치 x
//     * @param y     현재 위치 y
//     * @param idx   다음에 비교할 wArr의 인덱스
//     * @return      남은 부분을 찾았으면 true
//     */
//    private boolean dfs(char[][] board, char[] wArr, boolean[][] visited,
//                        int x, int y, int idx) {
//        // 기저: 단어를 전부 찾았으면 true
//        if (idx == wArr.length) {
//            return true;
//        }
//
//        int n = board.length;
//        int m = board[0].length;
//
//        // 4방 탐색
//        for (int d = 0; d < 4; d++) {
//            int nx = x + dx[d];
//            int ny = y + dy[d];
//            // 범위 검사 + 미방문 + 다음 글자 일치 여부
//            if (nx >= 0 && nx < n && ny >= 0 && ny < m
//                    && !visited[nx][ny]
//                    && board[nx][ny] == wArr[idx]) {
//
//                visited[nx][ny] = true;
//                // 다음 글자(idx+1)를 찾아간다
//                if (dfs(board, wArr, visited, nx, ny, idx + 1)) {
//                    return true;
//                }
//                // 실패했으면 되돌리기
//                visited[nx][ny] = false;
//            }
//        }
//        return false;
//    }
}
