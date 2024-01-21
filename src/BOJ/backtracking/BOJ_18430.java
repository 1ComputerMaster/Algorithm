package BOJ.backtracking;
import java.util.*;
import java.io.*;

public class BOJ_18430 {
    static int N,M,ans;
    static boolean[][] visited;
    static int arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        ans = 0;

        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        go(0,0);
        System.out.println(ans);
    }

    private static void go(int idx,int sum) {
        if(idx == N*M){
            ans = Math.max(sum, ans);
            return;
        }
        int x = idx / M;
        int y = idx % M;
        if(x + 1 < N && y - 1 >= 0){
            if(!visited[x][y] && !visited[x][y - 1] && !visited[x + 1][y]) {
                visited[x][y] = true;
                visited[x][y - 1] = true;
                visited[x + 1][y] = true;
                go(idx + 1, sum + arr[x][y] * 2 + arr[x + 1][y] + arr[x][y - 1]);
                visited[x][y] = false;
                visited[x][y - 1] = false;
                visited[x + 1][y] = false;
            }
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            if(!visited[x][y] && !visited[x][y - 1] && !visited[x - 1][y]) {
                visited[x][y] = true;
                visited[x][y - 1] = true;
                visited[x - 1][y] = true;
                go(idx + 1, sum + arr[x][y] * 2 + arr[x - 1][y] + arr[x][y - 1]);
                visited[x][y] = false;
                visited[x][y - 1] = false;
                visited[x - 1][y] = false;
            }
        }
        if (x - 1 >= 0 && y + 1 < M) {
            if(!visited[x][y] && !visited[x][y + 1] && !visited[x - 1][y]) {
                visited[x][y] = true;
                visited[x][y + 1] = true;
                visited[x - 1][y] = true;
                go(idx + 1, sum + arr[x][y] * 2 + arr[x][y + 1] + arr[x - 1][y]);
                visited[x][y] = false;
                visited[x][y + 1] = false;
                visited[x - 1][y] = false;
            }
        }
        if (x + 1 < N && y + 1 < M) {
            if(!visited[x][y] && !visited[x][y + 1] && !visited[x + 1][y]) {
                visited[x][y] = true;
                visited[x][y + 1] = true;
                visited[x + 1][y] = true;
                go(idx + 1, sum + arr[x][y] * 2 + arr[x + 1][y] + arr[x][y + 1]);
                visited[x][y] = false;
                visited[x][y + 1] = false;
                visited[x + 1][y] = false;
            }
        }
        go(idx + 1, sum);
    }
}
