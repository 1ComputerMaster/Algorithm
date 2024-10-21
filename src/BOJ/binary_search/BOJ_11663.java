package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_11663 {
    static List<Integer> points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(sc.nextInt());
        }

        // 점을 정렬한다.
        Collections.sort(points);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            // start와 end 사이에 있는 점의 개수를 찾는다.
            int count = getPointCount(start, end);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    // start와 end 범위 안에 있는 점의 개수를 찾는다.
    private static int getPointCount(int start, int end) {
        int leftIdx = lowerBound(start);
        int rightIdx = upperBound(end);
        return rightIdx - leftIdx;
    }

    // start 이상인 첫 번째 위치를 찾는 함수 (lower bound) -> 조건 안에 있어야 하므로... bound를 사용함
    private static int lowerBound(int value) {
        int left = 0;
        int right = points.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (points.get(mid) >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // end 이하인 마지막 위치를 찾는 함수 (upper bound) -> 조건 안에 있어야 하므로... bound를 사용함
    private static int upperBound(int value) {
        int left = 0;
        int right = points.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (points.get(mid) >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
