package BOJ.shortest_path;

import java.util.Scanner;

public class BOJ_18243 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        for (int i = 0; i <= N; i++){
            for (int j = 0; j <= N; j++){
                map[i][j] = 1000_000_000;
            }
        }

        for (int i = 0; i < K; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[from][to] = 1;
            map[to][from] = 1;
        }

        for (int k = 0; k <= N; k++){
            for (int i = 0; i <= N; i++){
                for (int j = 0; j <= N; j++) {
                    if(i != j && map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j<= N; j++){
                if(i != j){
                    if(map[i][j] > 6){
                        System.out.println("Big World!");
                        return;
                    }
                }
            }
        }
        System.out.println("Small World!");
    }
}
