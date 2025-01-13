package BOJ.Data_Structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_17255_RE {
    static char[] crr;
    static Set<String> pathSet;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        crr = str.toCharArray();
        pathSet = new HashSet<>();
        N = str.length();
        for (int i = 0; i < str.length(); i++){
            dfs(i,i,str.toCharArray()[i] + "", str.toCharArray()[i] + "");
        }
        System.out.println(pathSet.size());
    }

    private static void dfs(int left, int right, String str, String path) {
        if(left == 0 && right == N - 1){
            pathSet.add(path);
            return;
        }
        if(left > 0){
            dfs(left - 1, right, crr[left - 1] + str,path + ":" + crr[left - 1] + str);
        }
        if(right < N - 1){
            dfs(left, right + 1, str + crr[right + 1],path + ":" + str + crr[right + 1]);
        }
    }
}
