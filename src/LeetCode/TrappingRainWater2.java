package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater2 {
    public static void main(String[] args) {
        TrappingRainWater2 trw2 = new TrappingRainWater2();
        int[][] heightMap = {
            {3,3,3,3,3},
            {3,2,2,2,3},
            {3,2,1,2,3},
            {3,2,2,2,3},
            {3,3,3,3,3}
        };
        System.out.println(trw2.trapRainWater(heightMap)); // 4
    }
    int[] dx = {0, -1, 1, 0};
    int[] dy = {-1, 0, 0, 1};
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq = new PriorityQueue(Comparator.comparingInt((int[] o) -> o[0]));
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(i == 0 || i == n - 1){
                for(int j = 0; j < m; j++){
                    pq.offer(new int[] {heightMap[i][j], i , j});
                    visited[i][j] = true;
                }
            }else{
                pq.offer(new int[] {heightMap[i][0], i , 0});
                pq.offer(new int[] {heightMap[i][m - 1], i , m - 1});
                visited[i][0] = true;
                visited[i][m - 1] = true;
            }
        }
        int water = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int height = cur[0];
            int x = cur[1];
            int y = cur[2];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < n && ny < m && nx >= 0 && ny >= 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    water += Math.max(0, height - heightMap[nx][ny]);
                    pq.offer(new int[] {Math.max(height, heightMap[nx][ny]), nx, ny});
                }
            }
        }
        return water;
    }
}
