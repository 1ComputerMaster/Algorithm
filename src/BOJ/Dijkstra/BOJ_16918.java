package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_16918 {
    static char[][] map;

    static boolean[][]check;
    static int R, C, N;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        R = Integer.parseInt(tk.nextToken()); // 행
        C = Integer.parseInt(tk.nextToken()); // 열
        N = Integer.parseInt(tk.nextToken()); // 초
        map = new char[R][C];
        check = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = in.readLine().toCharArray();
        }
        N -= 1;
        for (int t = 1; t <= N; t++) {
            if (t % 2 == 1) {
                checkBombs();
                installBombs();
            } else {
                explodeBombs();
                check = new boolean[R][C];
            }
        }

        printMap();
    }

    private static void checkBombs() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    check[i][j] = true;
                }
            }
        }
    }

    private static void installBombs() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                }
            }
        }
    }

    private static void explodeBombs() {
        char[][] newMap = new char[R][C];
        for (char[] c : newMap)
            Arrays.fill(c,'O');

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (check[i][j]) {
                    newMap[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            newMap[nx][ny] = '.';
                        }
                    }
                }
            }
        }
        map = newMap;
    }

    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}