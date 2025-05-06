package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212 {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int R = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());

        String[][] map = new String[R][C];

        for (int i = 0; i < R; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            String[] str = tk.nextToken().split("");
            for (int j = 0; j < C; j++){
                map[i][j] = str[j];
            }
        }
        String[][] tempMap = tempMapCreator(map);
        map = transformMap(map, tempMap);
        String[][] ans = summationMap(map);

        for (String[] strings : ans) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    private static String[][] summationMap(String[][] map) {
        int minX = 100_000_000;
        int maxX = -1;
        int minY = 100_000_000;
        int maxY = -1;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if(map[i][j].equals("X")){
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        String[][] ans = new String[maxX + 1 - minX][maxY + 1 - minY];
        for (int i = minX; i <= maxX; i++){
            for (int j = minY; j <= maxY; j++){
                ans[i - minX][j - minY] = map[i][j];
            }
        }
        return ans;
    }

    private static String[][] tempMapCreator(String[][] map) {
        String[][] tmp = new String[map.length][map[0].length];
        for (int i = 0 ; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    private static String[][] transformMap(String[][] map, String [][] tempMap) {
        for (int i = 0 ; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if(map[i][j].equals("X")){
                    int desertCnt = 0;
                    for (int d = 0; d < 4; d++){
                        if(desertCnt > 1){
                            continue;
                        }
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[i].length){

                            if(!map[nx][ny].equals(".")){
                                desertCnt++;
                            }
                        }
                    }
                    if(desertCnt <= 1){
                        tempMap[i][j] = ".";
                    }
                }
            }
        }
        return tempMap;
    }
}
