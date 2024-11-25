package BOJ.shortest_path;

import java.util.Scanner;

public class BOJ_1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        boolean [][] friend = new boolean[N][N];

        for (int i = 0; i < N; i++){
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < N; j++){
                if(map[i][j] == 'Y'){
                    friend[i][j] = true;
                }
            }
        }

        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(map[i][j] != 'Y' && (map[i][k] == 'Y' && map[k][j] == 'Y') && i != j){
                        friend[i][j] = true;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++){
            int maxI = 0;
            for (int j = 0; j < N; j++){
                if(friend[i][j]){
                    maxI++;
                }
            }
            max = Math.max(max, maxI);
        }
        System.out.println(max);
    }
}
