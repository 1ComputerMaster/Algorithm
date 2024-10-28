package BOJ.binary_search;

import java.util.Scanner;

public class BOJ_20444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        int lec = 1;
        int cnt = 0;
        int width = 0;
        int height = 0;
        while (lec < k) {
            if(lec == k){
                System.out.println("YES");
            }else {
                lec = (width + height) * 2;
                if (cnt < k) {
                    if (width > height) {
                        width++;
                    } else {
                        height++;
                    }
                    width++;
                    cnt++;
                } else {
                    cnt--;
                    if (width > height) {
                        if (lec > k) {
                            width--;
                        }
                    } else {
                        if (lec > k) {

                        }
                    }
                }
            }
        }
    }
}
