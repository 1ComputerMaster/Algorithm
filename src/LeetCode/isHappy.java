package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class isHappy {
    public static void main(String[] args) {
        isHappy solution = new isHappy();
        System.out.println(solution.isHappy(19)); // Output: true
        System.out.println(solution.isHappy(2));  // Output: false

    }
    static Map<Integer, Integer> before = new HashMap<>();
    public boolean isHappy(int n) {
        before.clear();
        if(n == 1){
            return true;
        }
        return define(n);
    }
    private boolean define(int n){
        String num = String.valueOf(n);

        int ans = 0;
        for(int i = 0; i < num.length(); i++){
            int to = num.charAt(i) - '0';
            if(to == 0){
                continue;
            }
            ans += (to * to);
        }
        if(ans == 1)
            return true;
        if(before.getOrDefault(ans, -1) != -1){
            return false;
        }
        before.put(ans, ans);
        return define(ans);
    }
}
