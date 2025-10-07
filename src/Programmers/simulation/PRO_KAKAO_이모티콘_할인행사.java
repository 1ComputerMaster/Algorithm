package Programmers.simulation;

public class PRO_KAKAO_이모티콘_할인행사 {
    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        PRO_KAKAO_이모티콘_할인행사 sol = new PRO_KAKAO_이모티콘_할인행사();
        int[] ans = sol.solution(users,emoticons);
        System.out.println(ans[0] + " " + ans[1]);
    }
    private static final int[] RATES = {10, 20, 30, 40};
    private int[][] users;      // [][0]=minDiscount, [][1]=priceThreshold
    private int[] emoticons;    // 가격 배열
    private int m;              // 이모티콘 개수
    private int[] assigned;     // 각 이모티콘에 할당된 할인율
    private int bestSubscribers;
    private int bestRevenue;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.m = emoticons.length;
        this.assigned = new int[m];
        this.bestSubscribers = 0;
        this.bestRevenue = 0;

        dfs(0);  // 이모티콘별 할인율 전수조사
        return new int[]{bestSubscribers, bestRevenue};
    }

    private void dfs(int idx){
        if (idx == m) { // 모든 이모티콘 할인율 결정됨 → 평가
            evaluate();
            return;
        }
        for (int r : RATES) {
            assigned[idx] = r;
            dfs(idx + 1);
        }
    }

    private void evaluate(){
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int minDisc = user[0];       // 이 최소 할인율 이상만 구매
            int threshold = user[1];     // 이 이상이면 구독 전환

            int spend = 0;

            for(int i = 0; i < m; i++){
                if (assigned[i] >= minDisc) {
                    // 할인 적용가 = price * (100 - rate) / 100
                    spend += emoticons[i] * (100 - assigned[i]) / 100;
                }
            }

            if (spend >= threshold) {
                subscribers++;
                // 구독하면 해당 사용자 매출은 0 (문제 정의)
            } else {
                revenue += spend;
            }

        }

        // 가입자 수 우선, 매출 차선
        if (subscribers > bestSubscribers ||
                (subscribers == bestSubscribers && revenue > bestRevenue)) {
            bestSubscribers = subscribers;
            bestRevenue = revenue;
        }

    }
}
