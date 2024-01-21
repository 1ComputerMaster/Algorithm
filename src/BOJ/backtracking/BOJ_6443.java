package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_6443 {
    static char[] crr;
    static int[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            String str = tk.nextToken();
            crr = str.toCharArray();
            visited = new int[26];
            for(char now : crr){
                visited[now - 'a']++;
            }
            go(0,"");
        }
        System.out.println(sb.toString());
    }

    private static void go(int idx,String str) {
        if(idx == crr.length){
            sb.append(str + "\n");
            return;
        }
        for(int i = 0; i < 26; i++){
            if(visited[i] > 0){
                visited[i]--;
                go(idx + 1, str + (char) ('a'+ i));
                visited[i]++;
            }
        }
    }
}