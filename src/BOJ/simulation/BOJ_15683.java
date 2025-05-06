package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
    private static int N, M;
    private static int ans = 1000_000_000;

    private static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class CCTV{
        int x;
        int y;
        int type;
        public CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    private static List<CCTV> cctvList;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        int[][] map = new int[N][M];
        int cnt = 0;
        cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    cnt++;
                    cctvList.add(new CCTV(i,j, map[i][j]));
                }
            }
        }
        dfs(map, cnt);
        System.out.println(ans);
    }

    private static void dfs(int[][] tmpMap, int cnt) {
        if(cnt == 0){
            ans = Math.min(ans, countMap(tmpMap));
            return;
        }
        CCTV currentCCTV = cctvList.get(cnt-  1);
        cnt--;
        List<Point> changes; // 변경된 셀들을 기록할 리스트
        switch (currentCCTV.type) {
            case 1: // 타입 1: 한 방향만 감시 → 4가지 경우
                changes = goEast(tmpMap, currentCCTV.x, currentCCTV.y);
                dfs(tmpMap, cnt);
                revertMap(tmpMap ,changes);

                changes = goSouth(tmpMap, currentCCTV.x, currentCCTV.y);
                dfs(tmpMap, cnt);
                revertMap(tmpMap ,changes);

                changes = goWest(tmpMap, currentCCTV.x, currentCCTV.y);
                dfs(tmpMap, cnt);
                revertMap(tmpMap ,changes);

                changes = goNorth(tmpMap, currentCCTV.x, currentCCTV.y);
                dfs(tmpMap, cnt);
                revertMap(tmpMap ,changes);
                break;
            case 2: // 타입 2: 두 방향 → 경우 1: 동+서, 경우 2: 남+북
                changes = new ArrayList<>();
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);
                break;
            case 3: // 타입 3: 두 방향, 직각 방향 → 4가지 경우
                changes = new ArrayList<>();
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);
                break;
            case 4: // 타입 4: 세 방향 → 4가지 경우
                changes = new ArrayList<>();
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);

                changes = new ArrayList<>();
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);
                break;
            case 5: // 타입 5: 모든 방향 → 단 한 가지 경우
                changes = new ArrayList<>();
                changes.addAll(goEast(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goSouth(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goWest(tmpMap, currentCCTV.x, currentCCTV.y));
                changes.addAll(goNorth(tmpMap, currentCCTV.x, currentCCTV.y));
                dfs(tmpMap, cnt);
                revertMap(tmpMap,changes);
                break;
        }
    }
    private static int countMap(int[][] tmpMap) {
        int cnt = 0;
        for (int i = 0; i <  N; i++){
            for (int j = 0; j < M; j++){
                if(tmpMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static void revertMap(int[][] map, List<Point> changed){
        for (Point changedPoint : changed) {
            map[changedPoint.x][changedPoint.y] = 0;
        }
    }
    private static List<Point> goEast(int[][] tempMap, int startX, int startY) {
        List<Point> changed = new ArrayList<>();
        for (int j = startY + 1; j < M; j++) {
            if (tempMap[startX][j] == 6) { // 벽이면 중단
                break;
            }
            if (tempMap[startX][j] != 0) { // 이미 감시된 곳이나 CCTV가 있으면 그냥 지나감
                continue;
            }
            tempMap[startX][j] = -1; // 감시되었음을 표시 (예: -1)
            changed.add(new Point(startX, j));
        }
        return changed;
    }

    private static List<Point> goSouth(int[][] tempMap, int startX, int startY) {
        List<Point> changed = new ArrayList<>();
        for (int i = startX + 1; i < N; i++) {
            if (tempMap[i][startY] == 6) {
                break;
            }
            if (tempMap[i][startY] != 0) {
                continue;
            }
            tempMap[i][startY] = -1;
            changed.add(new Point(i, startY));
        }
        return changed;
    }

    private static List<Point>  goWest(int[][] tempMap, int startX, int startY) {
        List<Point> changed = new ArrayList<>();
        for (int j = startY - 1; j >= 0; j--) {
            if (tempMap[startX][j] == 6) {
                break;
            }
            if (tempMap[startX][j] != 0) {
                continue;
            }
            tempMap[startX][j] = -1;
            changed.add(new Point(startX, j));
        }
        return changed;
    }


    private static List<Point> goNorth(int[][] tempMap, int startX, int startY) {
        List<Point> changed = new ArrayList<>();
        for (int i = startX - 1; i >= 0; i--) {
            if (tempMap[i][startY] == 6) {
                break;
            }
            if (tempMap[i][startY] != 0) {
                continue;
            }
            tempMap[i][startY] = -1;
            changed.add(new Point(i, startY));
        }
        return changed;
    }
}
