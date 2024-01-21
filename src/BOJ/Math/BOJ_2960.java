package BOJ.Math;

import java.util.*;

public class BOJ_2960 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 2; i <= N; i++){
            map.put(i,1);
        }
        for (int j = 2; j <= N; j++) {
            if(check(j)) {
                for (int i = j; i <= N; i += j) {
                    if (map.getOrDefault(i,0) != 0) {
                        cnt++;
                        if (cnt == K) {
                            System.out.println(i);
                        }
                        map.put(i,0);
                    }
                }
            }
        }
    }

    private static boolean check(int j) {
        for (int k = 2; k < Math.sqrt(j); k++) { //소수로 지우기
            if(j % k == 0){
                return false;
            }
        }
        return true;
    }
}
