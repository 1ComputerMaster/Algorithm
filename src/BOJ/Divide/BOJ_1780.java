package BOJ.Divide;

import java.util.Scanner;

public class BOJ_1780 {
    static int[] result = new int[3]; // -1, 0, 1 Status
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        divide(map, 0, 0, N); // 시작 좌표와 사이즈
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void divide(int[][] map, int startX, int startY, int size) {
        // 현재 영역이 모두 같은 숫자인지 검사
        if (isUniform(map, startX, startY, size)) {
            int value = map[startX][startY]; // -1, 0, 1 중 하나
            result[value + 1]++; // -1 -> result[0], 0 -> result[1], 1 -> result[2]
            return;
        }

        // 현재 영역이 모두 같지 않으면 9개로 나누어 재귀 호출
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(map, startX + i * newSize, startY + j * newSize, newSize);
            }
        }
    }

    private static boolean isUniform(int[][] map, int startX, int startY, int size) {
        int value = map[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (map[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}