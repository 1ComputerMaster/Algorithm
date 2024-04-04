package BOJ.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_20115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list,Collections.reverseOrder());
        double num = list.get(0);
        for (int i = 0; i < list.size(); i++){
            if(i == 0){
                continue;
            }else {
                num += ((double) list.get(i) / 2);
            }
        }
        if(num == (int) num){
            System.out.println((int)num);
        }else{
            System.out.println(num);
        }
    }
}
