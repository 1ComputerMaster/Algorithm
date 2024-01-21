package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {
    static int N;

    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(tk.nextToken());

        ans = Integer.MIN_VALUE;
        int arr[][] = new int[N][2];
        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(tk.nextToken()); // Durability
            arr[i][1] = Integer.parseInt(tk.nextToken()); // Weight
        }
        go(arr,0);
        System.out.println(ans);
    }

    private static void go(int[][] arr, int idx) {
        if (idx == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] <= 0) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
            return;
        }

        if (arr[idx][0] <= 0) {
            go(arr, idx + 1); // 현재 계란이 깨져있는 경우 다음 계란으로 이동
        } else {
            boolean canBreak = false;
            for (int i = 0; i < N; i++) {
                if (i != idx && arr[i][0] > 0) {
                    arr[i][0] -= arr[idx][1];
                    arr[idx][0] -= arr[i][1];
                    canBreak = true;
                    go(arr, idx + 1);
                    arr[i][0] += arr[idx][1];
                    arr[idx][0] += arr[i][1];
                }
            }
            if (!canBreak) {
                go(arr, idx + 1); // 아무것도 치지 않은 경우의 수
            }
        }
    }
}
