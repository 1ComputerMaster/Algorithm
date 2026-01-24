package LeetCode;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]")); // Should print "aaabcbc"
        System.out.println(ds.decodeString("3[a2[c]]")); // Should print "accaccacc"
        System.out.println(ds.decodeString("2[abc]3[cd]ef")); // Should print "abcabccdcdcdef"
    }
    public String decodeString(String s) {
        Stack<Character> alpha = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        String n = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n += c;
                continue;
            }

            if (c == '[') {
                nums.push(Integer.parseInt(n));
                n = "";
                alpha.push('[');
                continue;
            }

            if (c == ']') {
                StringBuilder part = new StringBuilder();

                while(!alpha.isEmpty() && alpha.peek() != '['){
                    part.append(alpha.pop());
                }
                alpha.pop();
                part.reverse();

                int count = nums.pop();

                String repeated = part.toString().repeat(count);

                for (char ch : repeated.toCharArray()) {
                    alpha.push(ch);
                }
                continue;
            }

            // 일반 문자
            alpha.push(c);
        }

        // 남은 문자 조립 (스택이므로 역순으로 꺼내 뒤집어야 함)
        StringBuilder ans = new StringBuilder();
        while (!alpha.isEmpty()) {
            ans.append(alpha.pop());
        }
        return ans.reverse().toString();
    }

}
