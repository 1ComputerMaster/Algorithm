package Programmers.simulation;

public class PRO_KAKAO_WINTER_Mountain_Tiling {
        public int solution(int n, int[] tops) {
            final int MOD = 10007;

            int[] a = new int[n + 1]; // k번째 ▽를 "오른쪽과 묶은 상태"로 끝낸 경우
            int[] b = new int[n + 1]; // k번째 ▽를 "다른 방법(위/왼쪽/혼자)"으로 끝낸 경우

            // 초기 상태
            a[0] = 0;
            b[0] = 1;

            for (int k = 1; k < n; k++){
                a[k] = a[k - 1] + b[k - 1];
                if (tops[k - 1] == 1) {
                    b[k] = (2 * a[k - 1] + 3 * b[k - 1]) % MOD;
                }else{
                    b[k] = (a[k - 1] + 2 * b[k - 1]) % MOD;
                }
            }

            return (a[n] + b[n]) % MOD;
        }
    public static void main(String[] args) {
        PRO_KAKAO_WINTER_Mountain_Tiling sol = new PRO_KAKAO_WINTER_Mountain_Tiling();
        System.out.println(sol.solution(4, new int[]{1,1,0,1})); // 149
        System.out.println(sol.solution(2, new int[]{0,1}));     // 11
        System.out.println(sol.solution(10, new int[]{0,0,0,0,0,0,0,0,0,0})); // 7704
    }
}
