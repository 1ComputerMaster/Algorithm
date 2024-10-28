package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Integer> houses = new ArrayList<>();

        for (int i = 0; i < N; i++){
            houses.add(sc.nextInt());
        }

        Collections.sort(houses);
        int res = 0;

        int left = 1;
        int right = houses.get(houses.size() - 1);
        while (left <= right){
            int mid = (left + right) / 2;
            int router = countRouters(mid, houses);
            if(router  >= C) { // 설치 가능한 경우
                res = mid; // 일단 res를 mid로 갱신
                left = mid + 1; // 더 큰 간격을 시도
            } else {
                right = mid - 1; // 간격을 줄임
            }
        }
        System.out.println(res);
    }

    private static int countRouters(int length, List<Integer> houses) {
        int count = 1; // 첫 공유기는 첫 집에 설치
        int lastInstalled = houses.get(0);

        for (int i = 1; i < houses.size(); i++) {
            if (houses.get(i) - lastInstalled >= length) { // 조건을 만족하면 설치
                count++;
                lastInstalled = houses.get(i); // 마지막 설치 위치 업데이트
            }
        }
        return count;
    }
}
