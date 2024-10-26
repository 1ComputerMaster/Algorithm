package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_3079 {
    /*
    * 이분 탐색 + 중복 조합
    * */
    static int N,M;
    static List<Long> simsa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        simsa = new ArrayList<>();
        for (int i = 0; i < N; i++){
            simsa.add(sc.nextLong());
        }
        long left = 1;  // 최소 시간
        long right = Collections.max(simsa) * M;  // 최대 시간 (가장 오래 걸리는 심사대에서 모든 인원을 심사할 경우)
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2; //시간 범위를 구해서 거기에 맞춘다.
            if (canCompleteWithinTime(mid)) {
                result = mid;  // 가능하면 더 작은 시간으로도 되는지 확인
                right = mid - 1;
            } else {
                left = mid + 1; // 값을 높여서 더 큰 숫자에서는 되는지 확인
            }
        }
        System.out.println(result);
    }

    private static boolean canCompleteWithinTime(long timeLimit) {
        long peopleProcessed = 0;
        for (long time : simsa){
            peopleProcessed += timeLimit / time; //심사대에서 timeLimit 이내에 배치된 time 으로 나누어서 진행한다.
            if (peopleProcessed >= M) {  // 이미 필요한 인원을 충족했다면 더 이상 계산할 필요 없음
                return true;
            }
        }
        return peopleProcessed >= M;
    }

}

