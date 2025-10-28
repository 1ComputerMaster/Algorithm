package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aab";
        System.out.println(p.partition(s));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), s, result);
        return result;
    }

    private void dfs(int start, List<String> path, String s, List<List<String>> result){
        if(s.length() == start){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++){
            String substring = s.substring(start, i + 1);
            if(isPalindrome(substring)) {
                path.add(substring);
                dfs(i + 1, path, s, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
