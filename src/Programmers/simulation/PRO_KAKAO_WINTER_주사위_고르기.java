package Programmers.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PRO_KAKAO_WINTER_주사위_고르기 {
    public static void main(String[] args) {
        PRO_KAKAO_WINTER_주사위_고르기 sol = new PRO_KAKAO_WINTER_주사위_고르기();
        int[][] dices = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        int[] answers = sol.solution(dices);
        for (int ans : answers) {
            System.out.print(ans + " "); // Expected output: 1, 4
        }
    }
    int[][] dice;
    List<Integer> bestPicks;
    int bestWins = 0;
    public int[] solution(int[][] dice) {
        this.dice = dice;
        int n = dice.length;
        comb(0,0, new ArrayList<>());

        int[] answer = new int[bestPicks.size()];

        for (int i = 0; i < bestPicks.size(); i++){
            answer[i] = bestPicks.get(i) + 1;
        }
        return answer;
    }
    private void comb(int start, int depth, List<Integer> picks){
        if(depth == dice.length / 2){
            int wins = 0;
            wins = computeWins(picks);
            if(wins > bestWins){
                bestWins = wins;
                bestPicks = new ArrayList<>(picks);
            }
            return;
        }
        else{
            for(int i = start; i < dice.length; i++){
                picks.add(i);
                comb(i + 1, depth + 1, picks);
                picks.remove(picks.size() - 1);
            }
        }
    }
    private int computeWins(List<Integer> picks){
        List<Integer> aIdx = new ArrayList<>();
        List<Integer> bIdx = new ArrayList<>();

        for(int i = 0; i < dice.length; i++){
            if(picks.contains(i)){
                aIdx.add(i);
            }else {
                bIdx.add(i);
            }
        }
        List<Integer> aSums = new ArrayList<>();
        List<Integer> bSums = new ArrayList<>();

        dfsSums(0, 0, aIdx, aSums);
        dfsSums(0, 0, bIdx, bSums);

        // 정렬
        Collections.sort(aSums);
        Collections.sort(bSums);

        int wins = 0;
        for (int a : aSums){
            int cntLess = lower_bound(bSums, a);
            wins += cntLess;
        }
        return wins;
    }

    private int lower_bound(List<Integer> arr, int checker){
        int left = 0;
        int right = arr.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(arr.get(mid) < checker) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private void dfsSums(int depth, int sum, List<Integer> idxList, List<Integer> sums){
        if(depth == idxList.size()){
            sums.add(sum);
            return;
        }else{
            int diceIdx = idxList.get(depth);
            for (int face : dice[diceIdx]){
                dfsSums(depth + 1, sum + face, idxList, sums);
            }
        }
    }
}
