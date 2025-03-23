package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class BOJ_21610 {
    static int N, M;
    static int[][] A;  // 각 칸의 물의 양

    // 구름 위치 관리
    static List<Point> clouds;

    // 8방향 (문제에서 1~8)을 0-based로 정의
    // 문제 설명 기준:
    // 1: ← (0), 2: ↖ (1), 3: ↑ (2), 4: ↗ (3),
    // 5: → (4), 6: ↘ (5), 7: ↓ (6), 8: ↙ (7)
    // 아래 dx, dy는 index 0→←, 1→↖, 2→↑, 3→↗, ...
    static int[] dx = { 0, -1, -1, -1,  0,  1,  1,  1 };
    static int[] dy = {-1, -1,  0,  1,  1,  1,  0, -1 };

    // 대각선 방향(물복사버그용) ↖, ↗, ↘, ↙ (상하좌우는 제외)
    static int[] diagX = {-1, -1,  1,  1};
    static int[] diagY = {-1,  1, -1,  1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름: (N-1,0), (N-1,1), (N-2,0), (N-2,1)
        clouds = new ArrayList<>();
        clouds.add(new Point(N-1, 0));
        clouds.add(new Point(N-1, 1));
        clouds.add(new Point(N-2, 0));
        clouds.add(new Point(N-2, 1));

        // M번 명령 수행
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken()) - 1; // 0-based 방향
            int s = Integer.parseInt(st.nextToken());     // 이동 칸 수

            // 1. 구름 이동 (격자 밖으로 나가면 wrap-around)
            moveClouds(d, s);

            // 2. 구름이 있는 칸 물 1 증가
            boolean[][] visited = new boolean[N][N];
            for (Point c : clouds){
                visited[c.x][c.y] = true;
                A[c.x][c.y]++;
            }

            // 3. 물복사버그 (대각선 체크)
            for (Point c : clouds) {
                int count = 0;
                for (int idx = 0; idx < 4; idx++) {
                    int nx = c.x + diagX[idx];
                    int ny = c.y + diagY[idx];
                    if(inRange(nx, ny) && A[nx][ny] > 0) {
                        count++;
                    }
                }
                A[c.x][c.y] += count;
            }
            // 4. 구름 사라짐 → 새 구름 생성
            // 새 구름은 이번 턴에 구름이 없었던 칸 중 A[r][c]>=2 인 곳
            // 물 2 감소
            List<Point> newClouds = new ArrayList<>();
            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    if(A[r][c] >= 2 && !visited[r][c]){
                        A[r][c] -= 2;
                        newClouds.add(new Point(r,c));
                    }
                }
            }
            clouds = newClouds;
        }

        // 모든 이동 후 물의 합 계산
        long ans = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                ans += A[r][c];
            }
        }
        System.out.println(ans);
    }

    // 구름 이동: 방향 d로 s칸
    // 격자는 torus처럼 연결 (wrap-around)
    static void moveClouds(int d, int s){
        List<Point> moveClouds = new ArrayList<>();
        s = s % N;
        for (Point c : clouds) {
            int nx = c.x + dx[d]*s;
            int ny = c.y + dy[d]*s;

            nx = (nx % N + N) % N;
            ny = (ny % N + N) % N;
            moveClouds.add(new Point(nx, ny));
        }
        clouds = moveClouds;
    }

    static boolean inRange(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x=x; this.y=y;
        }
    }
}
