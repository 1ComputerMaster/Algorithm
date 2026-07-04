package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class kClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1])
        );

        return Arrays.copyOfRange(points, 0, k);
    }
}