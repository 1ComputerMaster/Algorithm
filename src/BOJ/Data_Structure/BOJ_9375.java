package BOJ.Data_Structure;

import java.util.*;

public class BOJ_9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            Map<String, Integer> clothTypeMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                sc.next(); // 의상 이름
                String type = sc.next(); // 의상 종류
                clothTypeMap.put(type, clothTypeMap.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (int count : clothTypeMap.values()) {
                ans *= (count + 1); // 해당 종류를 입지 않는 경우 포함
            }

            // 알몸이 아닌 경우를 제외 -1
            System.out.println(ans - 1);
        }
    }
}
