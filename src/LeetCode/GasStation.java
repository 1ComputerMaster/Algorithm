package LeetCode;

public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;  // 전체를 한 바퀴 돌았을 때 “잔여 기름” 합
        int surplus = 0;        // 현재 출발 지점부터의 “잔여 기름” 누적
        int start = 0;          // 유효한 출발 지점

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total_surplus += diff;
            surplus       += diff;

            if (surplus < 0) {
                // i번 주유소로 가는 도중 연료가 모자라면
                surplus = 0;      // 누적 재설정
                start   = i + 1;  // 다음 지점을 새 출발점으로 지정
            }
        }

        // 전체 순환 후에도 total_surplus<0 이면 출발점이 없는 것
        return (total_surplus < 0) ? -1 : start;

    }

}
