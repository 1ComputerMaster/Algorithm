package BOJ.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_13458
 */
public class BOJ_13458 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        for(int i = 0; i < N; i++){
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        int C = sc.nextInt();
        int temp = 0;
        long ans = 0;
        for(int i = 0; i < N; i++){
            temp=A.get(i)-B;
            ans++;
            if(temp <= 0){
                continue;
            }else{
                if(temp/C > 0){
                    ans += temp/C;
                    if(temp%C == 0){
                        continue;
                    }else{
                        ans++;
                    }
                }else{
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    
}