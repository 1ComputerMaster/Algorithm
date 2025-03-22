package BOJ.greedy;

import java.util.*;
//맨하탄 거리 문제
public class BOJ_14400 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] xs = new long[n];
        long[] ys = new long[n];

        for (int i = 0; i < n; i++){
            xs[i] = sc.nextLong();
            ys[i] = sc.nextLong();
        }

        // 각각 정렬
        Arrays.sort(xs);
        Arrays.sort(ys);

        // 중앙값: n이 짝수여도 아무 값 하나 선택해도 최적임
        long medianX = xs[n / 2];
        long medianY = ys[n / 2];

        long totalDist = 0;
        for (int i = 0; i < n; i++){
            totalDist += Math.abs(xs[i] - medianX);
            totalDist += Math.abs(ys[i] - medianY);
        }

        System.out.println(totalDist);
    }
}
