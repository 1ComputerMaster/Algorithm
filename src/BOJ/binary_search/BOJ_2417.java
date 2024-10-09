package BOJ.binary_search;

import java.util.Scanner;

public class BOJ_2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if(N == 0){
            System.out.println(0);
            return;
        }
        long left = 0;
        long right = (long) Math.pow(2,32);
        long answer = 0;  // 최종 답안 저장

        while (left <= right){
            long mid = (left + right) / 2;
            if (mid <= N / mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (answer * answer < N) {
            System.out.println(answer + 1);
        } else {
            System.out.println(answer);
        }

    }
}
