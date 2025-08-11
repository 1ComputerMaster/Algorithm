package LeetCode;

import java.util.*;

public class InsertIntervals {
    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insertIntervals.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        List<int[]> orderedList = new ArrayList<>(Arrays.asList(intervals));

        orderedList.add(newInterval);
        orderedList.sort(Comparator.comparingInt(o -> o[0]));
        int curStart = orderedList.get(0)[0];
        int curEnd = orderedList.get(0)[1];

        for(int[] num : orderedList){
            int s = num[0], e = num[1];

            if(curEnd >= s){
                curEnd = Math.max(e, curEnd);
            }else{
                res.add(new int[]{curStart, curEnd});
                curEnd = e;
                curStart = s;
            }
        }
        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
    }
}
