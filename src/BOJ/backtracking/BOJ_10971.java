package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
    static int N;
    static int w[][];
    static int ans;

    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());

        w = new int[N][N];

        ans = Integer.MAX_VALUE;



        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            for(int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        visited = new boolean[N];
        visited[0] = true;
        go(0, 0, 1);

        System.out.println(ans);

    }
    private static void go(int idx,int sum,int cnt) {
        if(cnt == N && w[0][idx] != 0){
            ans = Math.min(ans, sum + w[0][idx]);
            return;
        }else if(cnt >= N-1){
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i] && w[i][idx] != 0){
                visited[i] = true;
                go(i,sum + w[i][idx],cnt+1);
                visited[i] = false;
            }
        }
    }
}
