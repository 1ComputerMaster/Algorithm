package LeetCode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
 *
 * <p><b>English problem statement</b></p>
 *
 * <p>
 * You are given an {@code m x n} grid where each cell is either {@code 0} or {@code 1}.<br>
 * {@code 0} means an empty cell.<br>
 * {@code 1} means an obstacle.
 * </p>
 *
 * <p>
 * You start at the top-left cell {@code (0, 0)}, and you want to reach the
 * bottom-right cell {@code (m - 1, n - 1)}.
 * </p>
 *
 * <p>
 * You may move one step at a time in four directions:
 * up, down, left, and right.
 * </p>
 *
 * <p>
 * You are also given an integer {@code k}. You may eliminate at most {@code k}
 * obstacles while moving through the grid.
 * </p>
 *
 * <p>
 * Return the minimum number of steps required to reach the destination.<br>
 * If it is impossible to reach the destination, return {@code -1}.
 * </p>
 *
 * <p><b>Korean problem statement</b></p>
 *
 * <p>
 * {@code m x n} 크기의 {@code grid}가 주어진다. 각 칸은 {@code 0} 또는 {@code 1}이다.<br>
 * {@code 0}은 이동 가능한 빈 칸이다.<br>
 * {@code 1}은 장애물이다.
 * </p>
 *
 * <p>
 * 시작 위치는 왼쪽 위 칸 {@code (0, 0)}이고, 목표 위치는 오른쪽 아래 칸
 * {@code (m - 1, n - 1)}이다.
 * </p>
 *
 * <p>
 * 한 번에 상, 하, 좌, 우 네 방향 중 하나로 한 칸 이동할 수 있다.
 * </p>
 *
 * <p>
 * 정수 {@code k}가 함께 주어지며, 이동 중 최대 {@code k}개의 장애물을 제거하고
 * 지나갈 수 있다.
 * </p>
 *
 * <p>
 * 목표 지점까지 도달하는 데 필요한 최소 이동 횟수를 반환하라.<br>
 * 도달할 수 없다면 {@code -1}을 반환하라.
 * </p>
 *
 * <p><b>Important clarification</b></p>
 *
 * <p>
 * The same cell may need to be considered differently depending on how many
 * obstacle eliminations remain when you arrive there.<br>
 * 같은 좌표에 도착하더라도, 남은 장애물 제거 횟수가 다르면 이후에 갈 수 있는
 * 경로가 달라질 수 있다.
 * </p>
 */
public class ShortestPathInAGridWithObstaclesElimination {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    
    public int shortestPath(int[][] grid, int k) {
        if (grid.length == 1 && grid[0].length == 1) {
            return 0;
        }
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        return BFS(visited, grid, k);
    }

    private int BFS(boolean[][][] visited, int[][] grid, int k){
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, k, 0});
        visited[0][0][k] = true;
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int go = now[2];
            int nowDist = now[3];
            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx == n - 1 && ny == m - 1){
                    min = Math.min(nowDist + 1, min);
                }
                if (nx >= n || ny >= m || nx < 0 || ny < 0){
                    continue;
                }
                if (grid[nx][ny] == 1){
                    if (go - 1 >= 0 && !visited[nx][ny][go - 1]){
                        visited[nx][ny][go - 1] = true;
                        q.offer(new int[]{nx, ny, go - 1, nowDist + 1});
                    }
                }else{
                    if(visited[nx][ny][go]){
                        continue;
                    }
                    visited[nx][ny][go] = true;
                    q.offer(new int[]{nx, ny, go, nowDist + 1});
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestPathInAGridWithObstaclesElimination solution =
                new ShortestPathInAGridWithObstaclesElimination();

        run("LeetCode sample 1", () -> {
            int[][] grid = {
                    {0, 0, 0},
                    {1, 1, 0},
                    {0, 0, 0},
                    {0, 1, 1},
                    {0, 0, 0}
            };
            equal(6, solution.shortestPath(grid, 1), "minimum steps");
        });

        run("LeetCode sample 2 impossible with one elimination", () -> {
            int[][] grid = {
                    {0, 1, 1},
                    {1, 1, 1},
                    {1, 0, 0}
            };
            equal(-1, solution.shortestPath(grid, 1), "minimum steps");
        });

        run("start is already destination", () -> {
            int[][] grid = {
                    {0}
            };
            equal(0, solution.shortestPath(grid, 0), "minimum steps");
        });

        run("requires eliminating one obstacle", () -> {
            int[][] grid = {
                    {0, 1},
                    {0, 0}
            };
            equal(2, solution.shortestPath(grid, 1), "minimum steps");
        });

        run("cannot eliminate enough obstacles", () -> {
            int[][] grid = {
                    {0, 1},
                    {1, 0}
            };
            equal(-1, solution.shortestPath(grid, 0), "minimum steps");
        });
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            System.out.println("[PASS] " + name);
        } catch (Throwable error) {
            System.out.println("[FAIL] " + name);
            System.out.println("       " + error);
            throw error;
        }
    }

    private static void equal(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label + ": expected=" + expected + ", actual=" + actual);
        }
    }
}
