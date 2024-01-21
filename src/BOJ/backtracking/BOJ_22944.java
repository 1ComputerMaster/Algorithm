package BOJ.backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_22944 {
    static int n, h, d;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> umbs;
    static int[] start;
    static int[] end;
    static int INF = 99999999;
    static int answer = INF;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        d = Integer.parseInt(input[2]);

        visited = new boolean[n][n];
        umbs = new ArrayList<>();
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'U') {
                    umbs.add(new int[]{i, j});
                } else if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'E') {
                    end = new int[]{i, j};
                }
            }
        }

        dfs(start[0], start[1], h, 0, 0);

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void dfs(int y, int x, int health, int durability, int cnt) {
        int dist = Math.abs(end[0] - y) + Math.abs(end[1] - x);
        if (dist <= health + durability) {
            answer = Math.min(answer, cnt + dist);
            return;
        } else {
            for (int[] umb : umbs) {
                int uy = umb[0];
                int ux = umb[1];
                if (visited[uy][ux]) continue;
                int dist2 = Math.abs(uy - y) + Math.abs(ux - x);
                if (dist2 - 1 >= health + durability) continue;
                visited[uy][ux] = true;
                if (dist2 <= durability) {
                    dfs(uy, ux, health, d, cnt + dist2);
                } else {
                    dfs(uy, ux, health + durability - dist2, d, cnt + dist2);
                }
                visited[uy][ux] = false;
            }
        }
    }
}
