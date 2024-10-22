package BOJ.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //나무의 갯수
        int M = sc.nextInt(); //필요한 meter

        List<Integer> trees = new ArrayList<>();

        for (int i = 0; i < N; i++){
            trees.add(sc.nextInt());
        }
        Collections.sort(trees);

        int left = 0;
        int result = 0;
        int right = trees.get(trees.size() - 1);
        while (left <= right){
            int mid = (left + right) / 2;
            long meter = 0;
            for (int i = 0; i < N; i++){
                if(trees.get(i) < mid){
                    continue;
                }else {
                    meter += (trees.get(i) - mid);
                }
            }
            if(meter >= M){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
