package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[][] map = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        Queue<Data> q = new LinkedList<>();
        int cnt = 0;
        int maxRectangle = 0;
        int rectangleCurrent = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    q.add(new Data(i,j));
                    visited[i][j] = true;
                    rectangleCurrent = 1;
                    maxRectangle = Math.max(maxRectangle, rectangleCurrent);
                    while (!q.isEmpty()){
                        Data now = q.poll();
                        for (int d = 0; d < 4; d++){
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];
                            if(nx >= 0 && ny >= 0 && ny < m && nx < n && map[nx][ny] == 1 && !visited[nx][ny]){
                                q.add(new Data(nx, ny));
                                visited[nx][ny] = true;
                                maxRectangle = Math.max(maxRectangle, ++rectangleCurrent);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxRectangle);
    }
}
