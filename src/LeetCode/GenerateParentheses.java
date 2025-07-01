package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }
    private void dfs(int max, int open, int close, StringBuilder sb, List<String> ans){
        if (open == max && close == max) {
            ans.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append("(");
            dfs(max, open + 1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){ // max 로 설정하면 괄호의 기저 조건을 충족하지 못한다.
            sb.append(")");
            dfs(max, open, close + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
