package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11403_re {
/*

Dijkstra
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
        boolean first = false;
        while (!q.isEmpty()){
            int now = q.poll();
            if(visited[now]){
                continue;
            }
            visited[now] = true;
            for (int next = 0; next < map[now].length; next++){
                if(!first){
                    first = true;
                    visited[now] = false;
                }
                if(map[now][next] == 1){
                    if(next == start){
                        visited[start] = true;
                    }
                    q.offer(next);
                }
            }
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
*/

    /*
    * Floyd warshall
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for (int[] m : map){
            Arrays.fill(m, 1000_000_000);
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int temp = sc.nextInt();
                if(temp != 0)
                    map[i][j] = temp;
            }
        }


        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 1000_000_000) {
                    System.out.print(1 + " ");
                }else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }


    }

}