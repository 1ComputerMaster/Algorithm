package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11508 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<Integer> productList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(in.readLine());
            productList.add(num);
        }
        Collections.sort(productList,Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < N; i++){
            if(i % 3 != 2){
                total += productList.get(i);
            }
        }
        System.out.println(total);
    }
}
