package LeetCode;

import java.util.ArrayList;
import java.util.List;
/*
*
*   * LeetCode 78. Subsets
*   Given an integer array nums of unique elements, return all possible subsets (the power set).
*   The solution set must not contain duplicate subsets. Return the solution in any order.
*
*  풀이 : 백트래킹(재귀)을 이용한 풀이
* 1. result 리스트에 현재 부분집합을 추가
* 2. for문을 통해 현재 인덱스부터 배열의 끝까지 순회
*  - 현재 숫자를 부분집합에 추가
*  - 재귀 호출을 통해 다음 인덱스로 이동
*  - 부분집합에서 마지막 숫자를 제거하여 다음 숫자를 탐색할 준비
* 3. 최종적으로 모든 부분집합이 result에 추가되면 반환
*
* */

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets sol = new Subsets();
        System.out.println(sol.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> cur, int [] nums, int start){
        result.add(new ArrayList<>(cur));
        for(int i = start; i < nums.length; i++){
            cur.add((nums[i]));
            backtrack(result, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
