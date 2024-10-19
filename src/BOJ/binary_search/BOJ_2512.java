package BOJ.binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++){
            list.add(sc.nextInt());
            right = Math.max(right, list.get(i));
        }
        int M = sc.nextInt();

        while (left <= right){
            int mid = (left + right) / 2;
            int budget = 0;
            for (int i = 0; i < N; i++){
                budget += Math.min(list.get(i),mid);
            }
            if(budget <= M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right); //최적의 상한선의 값을 리턴하기 위해서

    }
}
