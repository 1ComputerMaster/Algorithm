package BOJ.backtracking;
import java.util.*;
import java.io.*;

public class BOJ_17136 {
    static int [][] map;
    static boolean [][] visited;

    static int[] cnt;
    static int N,ans;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        N = 10;
        map = new int[N][N];
        visited = new boolean[N][N];
        cnt = new int[5];
        for(int i = 0; i < 5; i++){
            cnt[i] = 5;
        }
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        dfs(0,0);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.print(ans);
        }
    }

    private static void dfs(int idx, int sum) {
        if(idx == N*N){
            ans = Math.min(ans,sum);
            return;
        }
        int x = idx / N;
        int y = idx % N;
        if(map[x][y] == 1 && !visited[x][y]){
           if(check(x, y, 4) && cnt[4] > 0) {
                cnt[4] -= 1;
                visitedTrue(x, y, 4);
                dfs(idx + 1, sum + 1);
                cnt[4] += 1;
                visitedFalse(x,y,4);
           }
            if(check(x, y, 3) && cnt[3] > 0) {
                cnt[3] -= 1;
                visitedTrue(x, y, 3);
                dfs(idx + 1, sum + 1);
                cnt[3] += 1;
                visitedFalse(x,y,3);
            }
            if(check(x, y, 2) && cnt[2] > 0) {
                cnt[2] -= 1;
                visitedTrue(x, y, 2);
                dfs(idx + 1, sum + 1);
                cnt[2] += 1;
                visitedFalse(x,y,2);
            }
            if(check(x, y, 1) && cnt[1] > 0) {
                cnt[1] -= 1;
                visitedTrue(x,y,1);
                dfs(idx+1, sum+1);
                cnt[1] += 1;
                visitedFalse(x,y,1);

            }
            if(check(x, y, 0) && cnt[0] > 0) {
                cnt[0] -= 1;
                visitedTrue(x, y, 0);
                dfs(idx + 1, sum + 1);
                cnt[0] += 1;
                visitedFalse(x,y,0);
            }
        }else{
            dfs(idx+1, sum);
        }
    }
    private static void visitedTrue(int x, int y ,int idx) {
        for(int i = idx; i >= 0; i--){
            for(int j = idx; j >= 0; j--) {
                visited[x + i][y + j] = true;
            }
        }
    }
    private static void visitedFalse(int x, int y ,int idx) {
        for(int i = idx; i >= 0; i--){
            for(int j = idx; j >= 0; j--) {
                visited[x + i][y + j] = false;
            }
        }
    }

    private static boolean check(int x, int y ,int idx) {
        for(int i = idx; i >= 0; i--){
            for(int j = idx; j >= 0; j--){
                if(x + i < 0 || x + i >= N || y + j >= N || y + j < 0){
                    return false;
                }else{
                    if(visited[x + i][y + j]){
                        return false;
                    }
                    if (map[x + i][y + j] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
