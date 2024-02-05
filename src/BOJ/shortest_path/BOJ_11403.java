package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403 {
    static int[][] map;
    static int[][] ans;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception{
        input();
        ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dijkstra(i);
            check(i);
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void check(int idx) {
        for (int i = 0; i < N; i++){
            if(visited[i]){
                ans[idx][i] = 1;
            }
        }
    }

    private static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        int cnt = 0;
        boolean first = false;
        while (!q.isEmpty()){
            int now = q.poll();
            if(visited[now]){
                continue;
            }
            cnt++;
            visited[now] = true;
            for (int next = 0; next < map[now].length; next++){
                if(next == start && visited[start] && map[now][next] == 1){
                    first = true;
                }
                if(!visited[next] && map[now][next] == 1){
                    q.offer(next);
                }
            }
        }
        if(!first){
            visited[start] = false;
        }
    }

    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
    }
}
