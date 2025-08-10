package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mergeIntervals.merge(intervals);
        for (int[] interval : merged) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int curStart = intervals[0][0];
        int curEnd   = intervals[0][1];

        for(int i = 0; i < intervals.length; i++){
            int s = intervals[i][0], e = intervals[i][1];
            if(curEnd >= s){
                curEnd = Math.max(curEnd, e);
            }else{
                res.add(new int[]{curStart, curEnd});
                curStart = s;
                curEnd   = e;
            }
        }
        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][2]);
    }
}
