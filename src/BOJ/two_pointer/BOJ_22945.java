package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 2) {
            // N이 2인 경우는 예외 처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int abilityA = Integer.parseInt(st.nextToken());
            int abilityB = Integer.parseInt(st.nextToken());

            System.out.println(Math.min(abilityA, abilityB));
            return;
        }

        long[] abilities = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            abilities[i] = Integer.parseInt(st.nextToken());
        }

        long maxAbility = 0;

        for (int i = 0; i < 3; i++) {
            long totalAbility = 0;

            for (int j = 0; j < N; j++) {
                if (i == 1 && (j == 0 || j == N - 1)) continue; // 중간 개발자 제외
                totalAbility += Math.min(abilities[j], abilities[(j + 1) % N]);
            }

            maxAbility = Math.max(maxAbility, totalAbility);
        }

        System.out.println(maxAbility);
    }
}
