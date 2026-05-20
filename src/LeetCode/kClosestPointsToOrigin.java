package LeetCode;

import java.util.Arrays;
public class kClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) ->
                Integer.compare(a[0] * a[0] + a[1] * a[1],
                        b[0] * b[0] + b[1] * b[1])
        );

        return Arrays.copyOfRange(points, 0, k);
    }
}