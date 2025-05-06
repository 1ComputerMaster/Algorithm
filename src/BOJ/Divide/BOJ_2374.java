package BOJ.Divide;

import java.io.*;
import java.util.*;

public class BOJ_2374 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        long ans = 0;
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(in.readLine());
            if(max < num){
                max = num;
            }
            if(!stack.isEmpty()){
                int top = stack.pop();
                if (top <= num) ans += num - top;
            }
            stack.push(num);
        }
        ans += max - stack.pop();
        System.out.println(ans);
    }
}