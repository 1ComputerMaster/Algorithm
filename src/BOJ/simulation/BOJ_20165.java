package BOJ.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_20165 {
    static String[][] visitedMap;
    static int[][] map;
    //북 (N), 서(W), 남(S), 동(E)
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N;
    static int M;

    static class Point {
        int x;
        int y;
        int power;

        public Point(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        map = new int[N][M];
        visitedMap = new String[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                visitedMap[i][j] = "S";
            }
        }
        int attackPoint = 0;
        for (int r = 0; r < R * 2; r++) {
            int startX = sc.nextInt() - 1;  // 0-based 인덱스로 변경
            int startY = sc.nextInt() - 1;

            if (r % 2 == 0) { // 공격 턴
                String way = sc.next();
                int dir = getDirection(way);
                attackPoint += attack(startX, startY, dir);
            } else { // 수비 턴
                visitedMap[startX][startY] = "S";
            }
        }

        System.out.println(attackPoint);
        printMap();
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visitedMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getDirection(String way) {
        switch (way) {
            case "N":
                return 0;
            case "W":
                return 1;
            case "S":
                return 2;
            case "E":
                return 3;
            default:
                return -1;
        }
    }


    private static int attack(int startX, int startY, int distance) {
        Queue<Point> weightQueue = new LinkedList<>();
        int fallingCount = 0;
        weightQueue.add(new Point(startX, startY, map[startX][startY]));

        while (!weightQueue.isEmpty()) {
            Point cur = weightQueue.poll();
            for (int i = 0; i < cur.power; i++) {
                int nx = cur.x + dx[distance] * i;
                int ny = cur.y + dy[distance] * i;
                if (isValid(nx, ny) && !visitedMap[nx][ny].equals("F")) {
                    visitedMap[nx][ny] = "F";
                    weightQueue.add(new Point(nx, ny, map[nx][ny]));
                    fallingCount++;
                }
            }
        }
        return fallingCount;

    }

    private static boolean isValid(int nx, int ny) {
        return (nx >= 0 && nx < N && ny < M && ny >= 0);
    }
}

