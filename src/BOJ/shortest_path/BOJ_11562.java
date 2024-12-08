package BOJ.shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11562 {
    /*
    * 처음에는 모든 케이스에 대해서 플로이드 와셜을 생각하였으나
    * 플로이드 와셜의 가공치를 이용해서 얼마의 최소 시간으로 접근 할 수 있는지 쉽게 구할 수 있었다.
    *
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE / 2);
            map[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        for (int i = 0; i < m; i++){
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int b = sc.nextInt();
            if(b == 0){
                map[u][v] = 0;
                map[v][u] = 1; // 못 가는 곳에 대한 최소한의 가중치 처리
            }else{
                map[u][v] = 0;
                map[v][u] = 0;
            }
        }

        int k = sc.nextInt();
        floydWarshall(n, map);
        for (int i = 0; i < k; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            System.out.println(map[s][e]);
        }
    }

    private static void floydWarshall(int n, int[][] map) {
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if(i != j){
                        if(map[i][j] > map[i][k] + map[k][j]){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
        }
    }
}
