package BOJ.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ_1935 {
    public static void main(String[] args) throws Exception{
        Stack<Double> st = new Stack<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();
        double ans = 0;

        double[] alpha = new double[26];

        for(int i = 0; i < N; i++){
            alpha[i] = Double.parseDouble(in.readLine());
        }

        for(char c : str.toCharArray()){
            if(c == '*'){
                    double b = st.pop();
                    double a = st.pop();
                    ans = a*b;
                    st.push(ans);
            }
            else if(c == '+'){
                    double b = st.pop();
                    double a = st.pop();
                    ans = a+b;
                    st.push(ans);
            }
            else if(c == '-'){
                    double b = st.pop();
                    double a = st.pop();
                    ans = a-b;
                    st.push(ans);

            }
            else if(c == '/'){
                    double b = st.pop();
                    double a = st.pop();
                    ans = a/b;
                    st.push(ans);
            }
            else{
                st.push(alpha[c-'A']);
            }
        }
        String str1 = String.format("%.2f", ans);
        System.out.println(str1);
    }

}
