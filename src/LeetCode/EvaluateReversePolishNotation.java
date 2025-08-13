package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(erpn.evalRPN(tokens)); // Should print 9
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();

        for(String str : tokens){
            if(isNumber(str)){
                st.add(Integer.parseInt(str));
            }else{
                int first = st.pop();
                int second = st.pop();
                if(str.equals("/")){
                    second = (int)(second / first);
                }
                if(str.equals("+")){
                    second = second + first;
                }
                if(str.equals("-")){
                    second = second - first;
                }
                if(str.equals("*")){
                    second = (int)(second * first);
                }
                st.add(second);
            }
        }
        return st.pop();
    }
    public  boolean isNumber(String strValue) {
        return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
    }
}
