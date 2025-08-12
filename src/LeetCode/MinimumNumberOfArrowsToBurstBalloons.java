package LeetCode;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons m = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(m.findMinArrowShots(points)); // Should print 2
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1],o2[1]));
        int arrows = 1;
        int preEnd = points[0][1];
        for(int[] point : points){
            if(preEnd < point[0]){
                preEnd = point[1];
                arrows++;
            }
        }
        return arrows;
    }
}
