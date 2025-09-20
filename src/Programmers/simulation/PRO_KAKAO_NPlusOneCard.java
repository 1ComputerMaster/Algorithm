package Programmers.simulation;
import java.util.*;

public class PRO_KAKAO_NPlusOneCard {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        Set<Integer> getCards = new HashSet<>();
        Set<Integer> goCards = new HashSet<>();

        // 초기 n/3장은 바로 손에 넣음
        for (int i = 0; i < n / 3; i++) {
            getCards.add(cards[i]);
        }

        int round = 1;
        for (int i = n / 3; i < n; i += 2) {
            boolean progressed = false;

            goCards.add(cards[i]);
            if(i + 1 < n) goCards.add(cards[i + 1]);

            // 동전 0개, 기존 카드 2개 사용
            for (int x : getCards){
                int y = target - x;
                if(x != y && getCards.contains(y)){
                    getCards.remove(x);
                    getCards.remove(y);
                    progressed = true;
                    break;

                }
            }
            //동전 1개 사용, 기존 카드 1개 사용
            if(!progressed && coin >= 1){
                for (int x : getCards){
                    int y = target - x;
                    if(goCards.contains(y)){
                        getCards.remove(x);
                        goCards.remove(y);
                        progressed = true;
                        coin--;
                        break;
                    }
                }
            }

            if(!progressed && coin >= 2){
                for (int x : goCards){
                    int y = target - x;
                    if(x != y && goCards.contains(y) && goCards.contains(x)){
                        goCards.remove(x);
                        goCards.remove(y);
                        progressed = true;
                        coin -= 2;
                        break;
                    }
                }
            }

            if (!progressed) break;
            round++;
        }

        return round;
    }

    public static void main(String[] args) {
        PRO_KAKAO_NPlusOneCard sol = new PRO_KAKAO_NPlusOneCard();
        System.out.println(sol.solution(4, new int[]{3,6,7,2,1,10,5,9,8,12,11,4})); // 5
        System.out.println(sol.solution(3, new int[]{1,2,3,4,5,8,6,7,9,10,11,12})); // 2
        System.out.println(sol.solution(2, new int[]{5,8,1,2,9,4,12,11,3,10,6,7})); // 4
        System.out.println(sol.solution(10, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18})); // 1
    }
}
