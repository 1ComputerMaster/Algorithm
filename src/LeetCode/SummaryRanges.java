package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            // 연속된 값이면 end 갱신
            if (cur == end + 1) {
                end = cur;
            } else {
                // 구간 종료: start == end 면 "start", 아니면 "start->end"
                addRange(result, start, end);
                // 새 구간 시작
                start = end = cur;
            }
        }
        // 마지막 구간 추가
        addRange(result, start, end);

        return result;
    }

    private void addRange(List<String> res, int s, int e) {
        if (s == e) {
            res.add(String.valueOf(s));
        } else {
            res.add(s + "->" + e);
        }
    }

    // 테스트
    public static void main(String[] args) {
        SummaryRanges sol = new SummaryRanges();
        System.out.println(sol.summaryRanges(new int[]{0,1,2,4,5,7}));
        // 출력: [0->2, 4->5, 7]

        System.out.println(sol.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        // 출력: [0, 2->4, 6, 8->9]
    }

}
