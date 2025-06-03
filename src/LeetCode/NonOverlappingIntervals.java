package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++){
            if(end > intervals[i][0]){
                cnt++;
            }else {
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
