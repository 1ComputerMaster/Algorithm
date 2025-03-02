package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17837 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int N,K;

    private static class Mal{
        int idx;
        int d;
        Mal(int idx, int d){
            this.idx = idx;
            this.d = d;
        }
    }
    private static class MalPosition{
        int H;
        int W;
        MalPosition(int H, int W){
            this.H = H;
            this.W = W;
        }
    }
    static List<Mal>[][] malMap;
    static Map<Integer, MalPosition> malPositionMap;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        map = new int[N][N];
        malMap = new ArrayList[N][N];
        malPositionMap = new HashMap<>();
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
                malMap[i][j] = new ArrayList<>();
            }

        }

        for (int i = 0; i < K; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int H = Integer.parseInt(tk.nextToken());
            int W = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());
            malMap[H - 1][W - 1].add(new Mal(i, d - 1));
            malPositionMap.put(i, new MalPosition(H - 1, W - 1));
        }
        int turn = 0;
        while (turn++ < 1000)
        {
            for (int i = 0; i < K; i++){
                WhiteCase(i);
                if(isGameOver(turn)){
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isGameOver(int turn) {
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if (malMap[i][j].size() >= 4) {
                    System.out.println(turn);
                    return true;
                }
            }
        }
        return false;
    }
    // 말 i를 한 번 이동시키고 리턴
    private static void WhiteCase(int nowMal){
        MalPosition malPosition = malPositionMap.get(nowMal);
        int x = malPosition.H;
        int y = malPosition.W;
        int d = 0;
        int stackIndex = 0;
        List<Mal> movingStack = new ArrayList<>();
        for(int index = 0; index < malMap[x][y].size(); index++){
            if(malMap[x][y].get(index).idx == nowMal) {
                d = malMap[x][y].get(index).d;
                movingStack = new ArrayList<>(
                        malMap[x][y].subList(index, malMap[x][y].size())
                );
                stackIndex = index;
                break;
            }
        }
        for (int i = malMap[x][y].size() - 1; i >= stackIndex; i--) {
            malMap[x][y].remove(i);
        }

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(!inRange(nx, ny) || map[nx][ny] == 2) {
            d = reverseDirection(d);
            movingStack.get(0).d = d; // 현재 이동 말의 방향 갱신
            nx = x + dx[d];
            ny = y + dy[d];
            // 다시 범위 밖이거나 파란 칸이면 -> 이동 안 하고 제자리로
            if(!inRange(nx, ny) || map[nx][ny] == 2) {
                // 그냥 원래 칸에 덩어리 쌓는다(순서 그대로)
                for (Mal piece : movingStack) {
                    malMap[x][y].add(piece);
                    malPositionMap.put(piece.idx, new MalPosition(x, y));
                }
                return;
            }
        }
        if (map[nx][ny] == 1) {
            Collections.reverse(movingStack);
        }

        // 5) 이동 칸에 movingStack을 쌓고, 위치 갱신
        for(Mal piece : movingStack) {
            // 만약 현재 이동 말이였으면, 위에서 방향 반전이 발생했을 수 있으므로
            // 그 말의 방향을 piece에 반영해야 할 수도 있음
            // => movingStack.get(0).d = d; // 이미 해둠
            malMap[nx][ny].add(piece);
            malPositionMap.put(piece.idx, new MalPosition(nx, ny));
        }
    }

    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < N && ny >= 0 && ny < N);
    }

    private static int reverseDirection(int d) {
        if(d % 2 == 0){
            return d + 1;
        }else{
            return d - 1;
        }
    }
}
