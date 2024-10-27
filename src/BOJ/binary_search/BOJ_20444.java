package BOJ.binary_search;

import java.util.Scanner;

public class BOJ_20444 {
    /**
     * 최초에는 가로 세로 선택에 따라서 달라지는 줄 알았으나
     * 실제로는 줄이 그이는 것 자체에 따라서 영향을 받기 때문에 이진 탐색으로 쉽게 구할 수 있었습니다.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long width = 0;
        long height = n;
        while (width <= height){
            long mid = (width + height) / 2;
            if ((mid + 1) * (n - mid + 1) == k){
                System.out.println("YES");
                return;
            }else if((mid + 1) * (n - mid + 1) < k){
                width = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        System.out.println("NO");
    }
}