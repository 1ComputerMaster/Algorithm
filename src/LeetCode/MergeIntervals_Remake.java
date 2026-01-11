package LeetCode;

import java.util.*;

public class MergeIntervals_Remake {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++){
            if(end < intervals[i][0]){
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(intervals[i][1], end);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        MergeIntervals_Remake mir = new MergeIntervals_Remake();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = mir.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
