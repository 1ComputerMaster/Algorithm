package BOJ.simulation;

import java.util.Scanner;

public class BOJ_14891 {
    static int[][] circleWheels = new int[4][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            String str = sc.next();
            String[] srr = str.split("");
            for (int j = 0; j < 8; j++){
                circleWheels[i][j] = Integer.parseInt(srr[j]);
            }
        }
        int K = sc.nextInt();
        int[] visited;

        for (int k = 0; k < K; k++){
            int numOfWheel = sc.nextInt() - 1;
            int dist = sc.nextInt();
            visited = new int[4];
            check(numOfWheel, visited, dist);
            for (int i = 0; i < 4; i++){
                if(visited[i] == 1){
                    circleWheels[i] = clockDist(circleWheels[i]);
                }
                else if(visited[i] == -1){
                    circleWheels[i] = oppositeClockDist(circleWheels[i]);
                }
            }
        }
        pointCounter();
    }

    private static void pointCounter() {
        int count = 0;
        for (int i = 0; i < 4; i++){
            if(circleWheels[i][0] == 1){
                count += (int) Math.pow(2, i);
            }
        }
        System.out.println(count);
    }

    private static void check(int num, int[] dist, int go){
        if(num + 1 < 4 && dist[num + 1] == 0) {
            if (circleWheels[num][2] == circleWheels[num + 1][6]) {
                dist[num] = go;
            } else {
                dist[num] = go;
                dist[num + 1] = -go;
                check(num + 1, dist, -go);
            }
        }
        if (num - 1 >= 0 && dist[num - 1] == 0) {
            if (circleWheels[num][6] == circleWheels[num - 1][2]) {
                dist[num] = go;
            } else {
                dist[num] = go;
                dist[num - 1] = -go;
                check(num - 1, dist, -go);
            }
        }
    }

    private static int[] clockDist(int [] wheel){
        int[] tmpWheel = new int[8];
        for (int i = 0; i < 8; i++){
            tmpWheel[i] = wheel[((i - 1) < 0) ? 7 : i - 1];
        }
        return tmpWheel;
    }
    private static int[] oppositeClockDist(int [] wheel){
        int[] tmpWheel = new int[8];
        for (int i = 0; i < 8; i++){
            tmpWheel[i] = wheel[((i + 1) >= 8) ? 0 : i + 1];
        }
        return tmpWheel;
    }
}
