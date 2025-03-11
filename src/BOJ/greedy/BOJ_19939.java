package BOJ.greedy;

import java.util.Scanner;

public class BOJ_19939 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 공의 개수
        int K = sc.nextInt();  // 바구니(팀) 수

        // 1) K개의 바구니에 1,2,3,...,K개씩 넣었을 때 총합
        long S = (long) K * (K + 1) / 2;  // 최소로 분배했을 때의 합

        // 2) 불가능 판정
        if (N < S) {
            System.out.println(-1);
            return;
        }

        // 3) leftover: 추가로 분배할 수 있는 공
        long leftover = N - S;

        // 4) leftover를 K개 바구니에 동일하게 나누고, 나머지가 있으면
        //    일부 바구니가 1개씩 더 받게 되므로, 차이가 +1 발생
        // -> leftover % K == 0 이면 차이 = (K - 1)
        // -> leftover % K != 0 이면 차이 = K
        long diff = (K - 1) + (leftover % K == 0 ? 0 : 1);
        System.out.println(diff);
    }
}