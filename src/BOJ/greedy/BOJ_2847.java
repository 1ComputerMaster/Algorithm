package BOJ.greedy;

import java.util.Scanner;

public class BOJ_2847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] score = new int[N];

        for(int i = 0; i < N; i++){
            score[i] = sc.nextInt();
        }

        long ans = 0;  // 감소 횟수를 누적
        // 오른쪽에서 왼쪽으로 순회
        for(int i = N - 2; i >= 0; i--){
            // 만약 왼쪽( i ) 레벨 점수가 오른쪽( i+1 ) 레벨 점수 이상이면 감소 필요
            if(score[i] >= score[i + 1]){
                // 목표는 score[i] < score[i+1]
                // 즉, score[i]를 score[i+1] - 1 로 만든다
                int diff = score[i] - (score[i + 1] - 1);
                ans += diff;
                score[i] -= diff;
            }
        }

        System.out.println(ans);
    }
}
