package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10159 {
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        M = Integer.parseInt(tk.nextToken());
        int map[][] = new int[N][N];
        int reverseMap[][] = new int[N][N];
        for(int tmp[] : map) {
            Arrays.fill(tmp, 1000_000_000);
        }
        for(int tmp[] : reverseMap) {
            Arrays.fill(tmp, 1000_000_000);
        }

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int from = Integer.parseInt(tk.nextToken()) - 1;
            int to = Integer.parseInt(tk.nextToken()) - 1;
            reverseMap[to][from] = 0;
            map[from][to] = 0;
        }
        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(i == j || (map[i][j] == 0 && reverseMap[i][j] == 0)){
                        continue;
                    }
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                    if(reverseMap[i][k] + reverseMap[k][j] < reverseMap[i][j]){
                        reverseMap[i][j] = reverseMap[i][k] + reverseMap[k][j];
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++){
            cnt = 0;
            for (int j = 0; j < N; j++) {
                if ((reverseMap[i][j] > 0 && map[i][j] > 0) && i != j){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
