package BOJ.Divide;

import java.util.Scanner;

public class BOJ_1780 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        mapNumberCounter(map);
    }

    private static void mapNumberCounter(int[][] map) {

    }
}
