package Programmers.simulation;

import java.util.HashMap;
import java.util.Map;

public class PRO_KAKAO_WINTER_가장_많이_받은_선물 {
    public static void main(String[] args) {
        PRO_KAKAO_WINTER_가장_많이_받은_선물 sol = new PRO_KAKAO_WINTER_가장_많이_받은_선물();
        String[] friends = {"alice", "bob", "carol"};
        String[] gifts = {"alice bob", "bob alice", "alice bob", "carol bob", "bob carol", "alice carol"};
        System.out.println(sol.solution(friends, gifts)); // Expected output: 2
    }
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> idxMap = new HashMap();
        int idx = 0;
        for(String str : friends){
            idxMap.put(str, idx++);
        }
        int[][] fromGift = new int[gifts.length][gifts.length];

        for(String str : gifts){
            String[] graph = str.split(" ");
            fromGift[idxMap.get(graph[0])][idxMap.get(graph[1])]++;
        }
        int[] presentPoints = new int[friends.length];

        for(String from : friends){
            int get = 0;
            int give = 0;
            for(String to : friends){
                if(from.equals(to)) {
                    continue;
                }
                give += fromGift[idxMap.get(from)][idxMap.get(to)];
                get += fromGift[idxMap.get(to)][idxMap.get(from)];
            }
            presentPoints[idxMap.get(from)] = give - get;
        }
        int[] presentVal = new int[friends.length];

        for(String from : friends){
            for(String to : friends){
                if(from.equals(to)) {
                    continue;
                }
                if(fromGift[idxMap.get(from)][idxMap.get(to)] > fromGift[idxMap.get(to)][idxMap.get(from)]){
                    presentVal[idxMap.get(from)]++;
                    answer = Math.max(answer, presentVal[idxMap.get(from)]);
                }else if(fromGift[idxMap.get(from)][idxMap.get(to)] == fromGift[idxMap.get(to)][idxMap.get(from)] && presentPoints[idxMap.get(from)] > presentPoints[idxMap.get(to)]){
                    presentVal[idxMap.get(from)]++;
                    answer = Math.max(answer, presentVal[idxMap.get(from)]);
                }
            }
        }
        return answer;
    }
}
