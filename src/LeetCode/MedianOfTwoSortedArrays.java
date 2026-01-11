package LeetCode;

import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));

    }
    /*
    * l1, l2 : 왼쪽 파티션의 '갯수'
    * nums1 [...left... | ...right...]
    *                 ^  ^
    *                 l1 r1
    * nums2 [...left... | ...right...]
    *                  ^  ^
    *                  l2 r2
    * l1 < r2 && l2 < r1
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //중간 위치를 이진탐색으로 찾아보자
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int halfLen = (m + n + 1) / 2;
        int imin = 0;
        int imax = m;
        while (imin <= imax) {
            int l1 = (imin + imax) / 2;
            int l2 = halfLen - l1;

            int Aleft = (l1 == 0) ? Integer.MIN_VALUE : nums1[l1 - 1]; //A의 왼쪽 경계값이 존재하지 않는 지점 (저점 무한대 -> 비교식 유지)
            int Aright = (l1 == m) ? Integer.MAX_VALUE : nums1[l1]; //A의 오른쪽 경계값이 존재하지 않는 지점 (무한대)
            int Bleft = (l2 == 0) ? Integer.MIN_VALUE : nums2[l2 - 1]; //B의 왼쪽 경계값이 존재하지 않는 지점 (저점 무한대 -> 비교식 유지)
            int Bright = (l2 == n) ? Integer.MAX_VALUE : nums2[l2]; //B의 오른쪽 경계값이 존재하지 않는 지점 (무한대)

            if (Aleft > Bright) {
                imax = l1 - 1;
            } else if(Bleft > Aright){
                imin = l1 + 1;
            }else {
                int maxLeft = Math.max(Aleft, Bleft);
                if((m + n)  % 2 == 1){
                    return maxLeft;
                }
                int minRight = Math.min(Aright, Bright);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
