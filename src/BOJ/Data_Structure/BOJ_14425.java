package BOJ.Data_Structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_14425 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String str = sc.next();
            map.put(str,i+1);
        }
        int ans = 0;
        for(int i = 0; i < M; i++){
            String str = sc.next();
            if(map.getOrDefault(str,0) != 0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
