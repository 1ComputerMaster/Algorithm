package BOJ.prefix_sum;

import java.util.Scanner;

public class BOJ_15724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];
        int[][] preSumMap = new int[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
                preSumMap[i][j] = map[i][j];
            }
        }



        for (int i = 0; i < N; i++){
            for (int j = 1; j < M; j++){
                preSumMap[i][j] += preSumMap[i][j - 1];
            }
        }

        int K = sc.nextInt();

        for (int i = 0; i < K; i++){
            int fromX = sc.nextInt() - 1;
            int fromY = sc.nextInt() - 1;
            int toX = sc.nextInt() - 1;
            int toY = sc.nextInt() - 1;
            int sum = 0;
            for (int k = fromX; k <= toX; k++){
                sum += preSumMap[k][toY] - (preSumMap[k][fromY] - map[k][fromY]);
            }

            System.out.println(sum);
        }

    }
}
