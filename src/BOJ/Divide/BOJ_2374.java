package BOJ.Divide;

import java.io.*;
import java.util.*;

public class BOJ_2374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력을 받으면서 스택에 저장 (연속된 같은 수는 하나로 압축)
        Stack<Long> stack = new Stack<>();
        long max = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(br.readLine());
            if(max < value) max = value;

            if (!stack.isEmpty()) {
                //현재의 근방의 차이만 구함
                long top = stack.pop();
                if (top <= value) ans += value - top;
            }
            stack.push(value);
        }

        ans += max - stack.pop(); //뒤에 들어 온게 작은 경우 처리
        // 즉, 어쨌든 후에 들어온 케이스는 모두 한 거대한 케이스에 의해서 모두 처리가 되므로 
        System.out.println(ans);
    }
}