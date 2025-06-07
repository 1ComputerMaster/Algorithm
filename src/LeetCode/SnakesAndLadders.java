package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println(snakesAndLadders(new int[][]{{-1,-1},{-1,3}}));
    }

    public static int snakesAndLadders(int[][] board) {
        int N = board.length;
        // 1차원 맵핑: move[k] == -1 이면 원래 칸, != -1 이면 사다리/뱀 목적지
        int[] move = new int[N * N + 1];
        int idx = 1;
        boolean leftToRight = true;
        for (int i = N - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < N; j++) {
                    move[idx++] = board[i][j];
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    move[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight; //넣는 순서 전이하여 1차원 배열에 매핑
        }

        // BFS 초기화
        boolean[] visited = new boolean[N * N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int moves = 0;

        // BFS 탐색
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                if (cur == N * N) {
                    return moves;        // 도착
                }
                // 주사위 굴려서 1~6칸 이동
                for (int d = 1; d <= 6; d++) {
                    int next = cur + d;
                    if (next > N * N) break;
                    // 사다리/뱀 처리
                    int dest = move[next] == -1 ? next : move[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1;  // 도달 불가
    }

}
