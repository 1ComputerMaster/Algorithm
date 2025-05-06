package BOJ.Data_Structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < A; i++){
            aMap.put(sc.nextInt(), 1);
        }
        for (int i = 0; i < B; i++){
            bMap.put(sc.nextInt(), 1);
        }

        System.out.println(mapChecker(aMap, bMap) + mapChecker(bMap, aMap));
    }

    private static int mapChecker(Map<Integer, Integer> aMap, Map<Integer, Integer> bMap) {
        int cnt = 0;
        for (int a : aMap.keySet()){
            if(!bMap.containsKey(a)){
                cnt++;
            }
        }
        return cnt;
    }
}
