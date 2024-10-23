package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt(); //랜선의 갯수
        int N = sc.nextInt(); //필요한 랜선의 갯수

        List<Long> lenLine = new ArrayList<Long>();
        for (int i = 0; i < K; i++){
            lenLine.add(sc.nextLong());
        }
        long left = 1;
        long right = Collections.max(lenLine);
        long result = 0;
        while (left <= right){
            long mid = (left + right) / 2;
            long centimeter = 0;
            for (int i = 0; i < K; i++){
                centimeter += lenLine.get(i) / mid;
            }
            if(centimeter >= N){
                left = mid + 1;
                result = mid;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
