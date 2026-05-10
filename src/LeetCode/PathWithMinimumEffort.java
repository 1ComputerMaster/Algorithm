package LeetCode;

import java.util.*;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        System.out.println(pathWithMinimumEffort.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[2]));
        queue.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = Objects.requireNonNull(cur)[0];
            int y = Objects.requireNonNull(cur)[1];

            if (x == m - 1 && y == n - 1) {
                return cur[2];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d][0];
                int ny = y + directions[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] > Math.max(cur[2], Math.abs(heights[x][y] - heights[nx][ny]))) {
                    dist[nx][ny] = Math.max(cur[2], Math.abs(heights[x][y] - heights[nx][ny]));
                    queue.offer(new int[]{nx, ny, Math.max(cur[2], Math.abs(heights[x][y] - heights[nx][ny]))});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
