package BOJ.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_17521 {
    private static List<Long> todayList;
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //날짜 수
        long W = sc.nextInt(); //초기 현금
        todayList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            long now = sc.nextLong();
            todayList.add(now);
        }
        int idx = 0;
        long coin = 0;
        while (idx < n - 1){

            idx = findDown(idx);
            if(W < todayList.get(idx)){
                idx = idx + 1;
                continue;
            }
            coin = W / todayList.get(idx);
            W = W % todayList.get(idx);


            idx = findUp(idx);
            W += todayList.get(idx) * coin;
        }

        System.out.println(W);
    }

    private static int findUp(int idx){
        while (idx < n - 1 && todayList.get(idx) <= todayList.get(idx + 1)) {
            idx++;
        }
        return idx;
    }

    private static int findDown(int idx){
        while (idx < n - 1 && todayList.get(idx) >= todayList.get(idx + 1)) {
            idx++;
        }
        return idx;
    }
}
