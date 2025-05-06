package BOJ.shortest_path;

import java.util.Scanner;

public class BOJ_1507_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(i == j || j == k || k == i){
                        continue;
                    }
                    if(map[i][j] > map[i][k] + map[k][j]){ //입력이 잘 못 된 경우 최소 간선의 크기로 들어와야 하는데 최소 간선의 크기가 아닌 값이 존재하므로
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][j] == map[i][k] + map[k][j]) // 이미 다른 최소 간선으로 업데이트가 가능하다면 현재 간선을 제거한다.
                        ans[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j < N; j++){
            for (int i = j + 1; i < N; i++) {
                  if(ans[j][i] == 0) { //제거 되지 않은 간선만 카운팅하여 진행
                      sum += (map[j][i]);
                  }
            }
        }
        System.out.println(sum);
    }
}
