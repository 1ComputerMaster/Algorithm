package BOJ.simulation;

import java.io.*;
import java.util.*;

public class BOJ_21922 {

    // 방향: 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited; // visited[x][y][dir]

    static class AirDirection {
        int x, y, dir; // dir: 바람의 진행 방향
        public AirDirection(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        visited = new boolean[N][M][4];
        List<Integer> acX = new ArrayList<>();
        List<Integer> acY = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) { // 에어컨이면
                    acX.add(i);
                    acY.add(j);
                }
            }
        }

        BFS(acX, acY, map, N, M);

        // 각 칸에 대해 4방향 중 하나라도 방문한 경우 카운트
        int ans = countingVisitedMap(N, M);
        System.out.println(ans);
    }

    private static int countingVisitedMap(int N, int M) {
        int ans = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                for (int d = 0; d < 4; d++){
                    if (visited[i][j][d]){
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private static void BFS(List<Integer> acX, List<Integer> acY, int[][] map, int N, int M) {
        // 다중 출발점: 모든 에어컨에서 4방향으로 시작
        Queue<AirDirection> q = new LinkedList<>();
        for (int k = 0; k < acX.size(); k++){
            int x = acX.get(k), y = acY.get(k);
            for (int d = 0; d < 4; d++){
                if (!visited[x][y][d]) {
                    visited[x][y][d] = true;
                    q.add(new AirDirection(x, y, d));
                }
            }
        }

        // BFS (실제로는 각 상태마다 고유의 후행 경로가 1개이므로 DFS와 동일하게 동작)
        while (!q.isEmpty()){
            AirDirection cur = q.poll();
            // 현재 칸 (cur.x, cur.y)에서 바람의 진행 방향 cur.dir로 도달한 상태.
            // 이 칸에 있는 물체(또는 빈 칸, 에어컨)에 따라 바람의 진행 방향이 바뀜.
            int nd = changeDir(map[cur.x][cur.y], cur.dir);
            int nx = cur.x + dx[nd], ny = cur.y + dy[nd];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visited[nx][ny][nd]){
                visited[nx][ny][nd] = true;
                q.add(new AirDirection(nx, ny, nd));
            }
        }
    }

    // object가 1, 2, 3, 4이면 각 물체의 반사 규칙에 따라 새 방향을 반환하고,
    // object가 0 또는 9이면 진행 방향를 그대로 반환합니다.
    private static int changeDir(int object, int dir) {
        if (object == 1) {
            // 물건1: 왼쪽(0) 또는 오른쪽(2)에서 도착하면 반대 방향으로 반사, 세로(1,3)는 그대로
            if (dir == 0 || dir == 2) return 2 - dir; // 0->2, 2->0
            return dir;
        }
        if (object == 2) {
            // 물건2: 위(3) 또는 아래(1)에서 도착하면 반대 방향 (1->3, 3->1), 가로(0,2)는 그대로
            if (dir == 1) return 3;
            if (dir == 3) return 1;
            return dir;
        }
        if (object == 3) {
            // 물건3 (거울):
            // 왼쪽(0) → 위(3), 아래(1) → 왼쪽(2), 오른쪽(2) → 아래(1), 위(3) → 오른쪽(0)
            if (dir == 0) return 3;
            if (dir == 1) return 2;
            if (dir == 2) return 1;
            if (dir == 3) return 0;
        }
        if (object == 4) {
            // 물건4 (거울):
            // 왼쪽(0) → 아래(1), 아래(1) → 오른쪽(0), 오른쪽(2) → 위(3), 위(3) → 왼쪽(2)
            if (dir == 0) return 1;
            if (dir == 1) return 0;
            if (dir == 2) return 3;
            if (dir == 3) return 2;
        }
        // object가 0(빈 칸)이나 9(에어컨)인 경우 변화 없음.
        return dir;
    }
}
