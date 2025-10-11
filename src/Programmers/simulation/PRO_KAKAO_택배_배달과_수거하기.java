package Programmers.simulation;

public class PRO_KAKAO_택배_배달과_수거하기 {
    public static void main(String[] args) {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        PRO_KAKAO_택배_배달과_수거하기 sol = new PRO_KAKAO_택배_배달과_수거하기();
        long ans = sol.solution(cap,n,deliveries,pickups);
        System.out.println(ans);
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int di = n - 1; // 배달 마지막 인덱스 포인터
        int pi = n - 1; // 수거 마지막 인덱스 포인터

        while (true) {
            // 뒤에서부터 남은 물량 있는 마지막 집 찾기
            while (di >= 0 && deliveries[di] == 0) di--;
            while (pi >= 0 && pickups[pi] == 0) pi--;

            // 둘 다 끝났으면 종료
            if (di < 0 && pi < 0) break;

            // 이번 트립의 최장 거리
            int farthest = Math.max(di, pi) + 1;
            answer += 2L * farthest;

            // 이번 트립에서 배달 cap만큼 소진 (뒤에서 앞으로 직접 깎기)
            int deliverCap = cap;
            for (int j = di; j >= 0 && deliverCap > 0; j--) {
                if (deliveries[j] == 0) continue;
                int use = Math.min(deliverCap, deliveries[j]);
                deliveries[j] -= use;
                deliverCap -= use;
            }

            // 이번 트립에서 수거 cap만큼 소진 (뒤에서 앞으로 직접 깎기)
            int pickupCap = cap;
            for (int j = pi; j >= 0 && pickupCap > 0; j--) {
                if (pickups[j] == 0) continue;
                int use = Math.min(pickupCap, pickups[j]);
                pickups[j] -= use;
                pickupCap -= use;
            }
            // 다음 while 루프 시작 시 di, pi는 다시 뒤에서부터 0 스킵하며 갱신됨
        }

        return answer;
    }
}
