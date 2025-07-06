package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()")); // Output: true
        System.out.println(validParentheses.isValid("()[]{}")); // Output: true
        System.out.println(validParentheses.isValid("(]")); // Output: false
        System.out.println(validParentheses.isValid("([)]")); // Output: false
        System.out.println(validParentheses.isValid("{[]}")); // Output: true
    }
    //  좋은 코드 형식은
    //  https://leetcode.com/problems/valid-parentheses/solutions/6315696/best-solution-ever-easy-implementation-multi-language-your-coding-mvp/
    //  위 내용 참고
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            st.push(s.charAt(i));
        }
        int open1 = 0;
        int open2 = 0;
        int open3 = 0;
        Stack<Integer> lastStatus = new Stack<>();
        while (!st.isEmpty()) {
            char cur = st.pop();
            if (cur == '(' ) {
                open1++;
                lastStatus.add(1);
            }
            if(cur == ')') {
                if(lastStatus.isEmpty()){
                    return false;
                }
                int status = lastStatus.pop();
                if (open1 == 0 || status != 1) {
                    return false;
                }
                open1--;
            }
            if (cur == '{') {
                open2++;
                lastStatus.add(2);
            }
            if(cur == '}') {
                if(lastStatus.isEmpty()){
                    return false;
                }
                int status = lastStatus.pop();
                if (open2 == 0 || status != 2) {
                    return false;
                }
                open2--;
            }

            if (cur == '[') {
                open3++;
                lastStatus.add(3);
            }
            if(cur == ']') {
                if(lastStatus.isEmpty()){
                    return false;
                }
                int status = lastStatus.pop();
                if (open3 == 0 || status != 3) {
                    return false;
                }
                open3--;
            }
        }
        return (open1 == 0 && open2 == 0 && open3 == 0);
    }
}
