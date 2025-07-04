package LeetCode;

public class WordSearch {
    // 4방 탐색 델타
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCCED";
        System.out.println(ws.exist(board, word)); // false
        word = "ABCCED";
        System.out.println(ws.exist(board, word)); // true
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        // word를 char[]로 변환 (원하시는 대로 int[]로 바꿔도 무방)
        char[] wArr = word.toCharArray();

        boolean[][] visited = new boolean[n][m];
        // 시작점 후보 모두 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == wArr[0]) {
                    // 첫 글자부터 맞으면 DFS 진입
                    visited[i][j] = true;
                    if (dfs(board, wArr, visited, i, j, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    /**
     * @param board 보드
     * @param wArr  찾을 단어의 char 배열
     * @param visited 방문 표시
     * @param x     현재 위치 x
     * @param y     현재 위치 y
     * @param idx   다음에 비교할 wArr의 인덱스
     * @return      남은 부분을 찾았으면 true
     */
    private boolean dfs(char[][] board, char[] wArr, boolean[][] visited,
                        int x, int y, int idx) {
        // 기저: 단어를 전부 찾았으면 true
        if (idx == wArr.length) {
            return true;
        }

        int n = board.length;
        int m = board[0].length;

        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 범위 검사 + 미방문 + 다음 글자 일치 여부
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny]
                    && board[nx][ny] == wArr[idx]) {

                visited[nx][ny] = true;
                // 다음 글자(idx+1)를 찾아간다
                if (dfs(board, wArr, visited, nx, ny, idx + 1)) {
                    return true;
                }
                // 실패했으면 되돌리기
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}
