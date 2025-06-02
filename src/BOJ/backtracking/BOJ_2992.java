package BOJ.backtracking;

import java.util.Scanner;

public class BOJ_2992 {
    static int ans = Integer.MAX_VALUE;
    static char[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = str.length();
        nums = new char[n];
        boolean[] visited = new boolean[n];
        comb(str, n, visited);
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    private static void comb(String str, int n, boolean[] visited) {
        if(n == 0){
            String s = new String(nums);
            int where = Integer.parseInt(s);
            if(Integer.parseInt(str) < where){
                ans = Math.min(ans, where);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            nums[n - 1] = str.charAt(i);
            comb(str, n - 1, visited);
            visited[i] = false;
        }
    }

}
