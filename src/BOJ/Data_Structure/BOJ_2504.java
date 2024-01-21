package BOJ.Data_Structure;
import java.util.*;
import java.io.*;

public class BOJ_2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str =  in.readLine();
        Stack<String> st = new Stack<>();
        char tmp = ' ';
        boolean isAble = true;
        for(int i = 0; i < str.length(); i++){
            String s = str.substring(i,i+1);
            if("(".equals(s)){
                st.push(")");
                continue;
            }
            if("[".equals(s)){
                st.push("]");
                continue;
            }
            int cnt = 0;
            while(true) {
                // 아직본인 괄호가 나오지 않았는데 스택이 비었다는 뜻 유효하지 않은 괄호 문자열
                if(st.isEmpty()) {
                    isAble = false;
                    break;
                }
                if(isNumber(st.peek())) {
                    cnt += Integer.parseInt(st.pop());
                }else {
                    if(isVPS(s, st.peek())) {
                        st.pop();
                        int t = (")".equals(s)) ? 2:3;

                        if(cnt == 0) {
                            st.push(String.valueOf(t));
                        }else {
                            st.push(String.valueOf(t * cnt));
                        }
                        break;
                        }else {
                            isAble = false;
                            break;
                        }
                    }
                }
                if(!isAble) break;
            }

            int result = 0;
            // 스택이 빌때까지 POP한다.
            //정상적인 괄호 문자열이라면 스택에는 숫자만 들어 있어야 한다.
            while(!st.isEmpty()) {
                if(isNumber(st.peek())) {
                    result += Integer.parseInt(st.pop());
                }else {
                    isAble = false;
                    break;
                }
            }
            if(isAble) System.out.println(result);
            else System.out.println(0);
        }

    public static boolean isVPS(String c, String target) {
        if(c.equals(target)) return true;
        return false;
    }

    // 두 괄호가 아니면 무조건 숫자이다.
    public static boolean isNumber(String str) {
        if(str.equals(")") || str.equals("]")) return false;
        return true;
    }

}
