package BOJ.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_21312 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[3];

        for (int i = 0; i < 3; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < 3; i++){
            int num = arr[i];
            if(num > ans && ans % 2 == 0){
                ans = num;
            }
            loop: for (int j = 0; j < 3; j++){
                if(j != i){
                    if(num * arr[j] > ans && (ans % 2 == 0)){
                        ans = num * arr[j];
                        num *= arr[j];
                    }
                    if((num * arr[j]) % 2 != 0 && num * arr[j] > ans){
                        ans = num * arr[j];
                        num *= arr[j];
                    }
                    for (int k = 0; k < 3; k++){
                        if(k != j && k != i){
                            if(num * arr[k] > ans && (ans % 2 == 0)){
                                ans = num * arr[k];
                                num *= arr[k];
                            }
                            if((num * arr[k]) % 2 != 0 && num * arr[k] > ans){
                                ans = num * arr[k];
                                num *= arr[k];
                            }
                            list.add(ans);
                            ans = 0;

                            break loop;
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));


    }
}
