package BOJ.Data_Structure;

import java.util.*;

public class BOJ_10546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < N; i++){
            String str = sc.next();
            participantMap.put(str, participantMap.getOrDefault(str, 0) +1);
        }
        for (int i = 0; i < N - 1; i++) {
            String str = sc.next();
            if(participantMap.get(str) <= 1) {
                participantMap.replace(str, participantMap.get(str) - 1);
            } else {
                participantMap.remove(str);
            }
        }
        for (String key : participantMap.keySet()){
            System.out.println(key);
        }
    }
}
