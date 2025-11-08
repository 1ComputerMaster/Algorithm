package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class LetterCombOfPhoneNum {
    public static void main(String[] args) {
        LetterCombOfPhoneNum sol = new LetterCombOfPhoneNum();
        String digits = "23";
        System.out.println(sol.letterCombinations(digits));
    }
    static Map <Integer, String> alphabetMap;
    static List<String> ans;
    public List<String> letterCombinations(String digits) {
        alphabetMap = new HashMap<>();
        alphabetMap.put(2, "abc");
        alphabetMap.put(3, "def");
        alphabetMap.put(4, "ghi");
        alphabetMap.put(5, "jkl");
        alphabetMap.put(6, "mno");
        alphabetMap.put(7, "pqrs");
        alphabetMap.put(8, "tuv");
        alphabetMap.put(9, "wxyz");
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++){
            nums.add(Integer.valueOf(digits.charAt(i) - '0'));
        }
        ans = new ArrayList();
        comb(nums,0 ,digits.length(), new StringBuilder());
        return ans;
    }
    private void comb(List<Integer> nums,int start, int cnt, StringBuilder sb){
        if(sb.length() == cnt){
            ans.add(sb.toString());
        }
        for(int i = start; i < nums.size(); i++){
            String str = alphabetMap.get(nums.get(i));
            for(int j = 0; j < str.length(); j++){
                comb(nums, i + 1, cnt, sb.append(str.charAt(j) + ""));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
