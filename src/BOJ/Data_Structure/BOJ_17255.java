package BOJ.Data_Structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_17255 {
    static char[] chars;
    static Set<String> pathSet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pathSet = new HashSet<>();
        chars = sc.next().toCharArray();

        for (int i = 0; i < chars.length; i++){
            dfs(i, i, String.valueOf(chars[i]), String.valueOf(chars[i]));
        }
        System.out.println(pathSet.size());
    }

    private static void dfs(int left, int right, String s, String path) {
        /*
        *
        * input이 9111이라면 pathSet은 아래와 같다.
        * 왼쪽에서 시작 오른쪽에서 시작
        * path : 아래 처럼 만들어진다.
        * 0 = "1:11:111:9111"
        * 1 = "1:11:911:9111"
        * 2 = "9:91:911:9111"
        * 3 = "1:91:911:9111"
        *
        * */
        if(left == 0 && right == chars.length - 1){
            pathSet.add(path);
            return;
        }
        if(left >= 1){
            dfs(left - 1, right, chars[left - 1] + s, path + ":" + chars[left - 1] + s); //모든 경우의 선을 즉, 가는 path를 저장해버린다.
        }
        if(right + 1 < chars.length) {
            dfs(left, right + 1, s + chars[right + 1], path + ":" + s + chars[right + 1]); //모든 경우의 선을 즉, 가는 path를 저장해버린다.
        }
    }
}
