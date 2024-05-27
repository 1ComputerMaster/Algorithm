package BOJ.Divide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int black = 0;
    static int white = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        div(0,0,N);
        System.out.println(white);
        System.out.println(black);
    }

    private static void div(int row, int col, int size) {
        boolean checker = true;
        int color = map[row][col];
        for (int i = row; i < row + size; i++){
            for (int j = col; j < col + size; j++){
                if(color != map[i][j])
                {
                    checker = false;
                    break;
                }
            }
        }
        if(size == 1){
            if(map[row][col] == 1){
                black++;
            }else{
                white++;
            }
            return;
        }
        if(color == 1 && checker) {
            black++;
        }else if(color == 0 && checker) {
            white++;
        }else {
            div(row, col, (size / 2));
            div(row, col + (size / 2), (size / 2));
            div(row + (size / 2), col, (size / 2));
            div(row + (size / 2), col + (size / 2), (size / 2));
        }
    }
}
