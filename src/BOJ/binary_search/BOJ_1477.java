package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1477 {
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        int L = sc.nextInt();
        List<Integer> comportZone = new ArrayList<>();

        for (int i = 0; i < N; i++){
            comportZone.add(sc.nextInt());
        }

        comportZone.add(0); // 고속도로 시작점
        comportZone.add(L); // 고속도로 끝점

        Collections.sort(comportZone);

        int left = 1;
        int right = L;
        int ans = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left + right) / 2;
            if(canIGo(mid,comportZone)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);

    }
    private static boolean canIGo(int length, List<Integer> comportZone){
        int cnt = 0;
        for (int i = 1; i < comportZone.size(); i++){
            cnt += (comportZone.get(i) - comportZone.get(i - 1) - 1) / length;
        }
        return cnt <= M;
    }
}
