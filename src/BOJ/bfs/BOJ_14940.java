package BOJ.bfs;
import java.util.*;
import java.io.*;
public class BOJ_14940 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int m;
    static int arr[][];

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        int[][] map = new int[n][m];
        arr = new int[n][m];
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            tk = new StringTokenizer(in.readLine()," ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if(map[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = -1;
                }
            }
        }

        BFS(map,x,y);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int[][] map, int x, int y) {
        Queue<Data> q = new LinkedList<Data>();
        q.add(new Data(x,y));
        arr[x][y] = 0;
        while(!q.isEmpty()){
            Data to = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = to.x + dx[d];
                int ny = to.y + dy[d];
                if(nx >= n || ny >= m || nx < 0 || ny < 0 || map[nx][ny] == 0){
                    continue;
                }else {
                    if (arr[nx][ny] == -1) {
                        arr[nx][ny] = arr[to.x][to.y] + 1;
                        q.add(new Data(nx,ny));
                    }
                }
            }
        }
    }
}
