///*
//문제
//수빈이는 A와 B로만 이루어진 영어 단어 존재한다는 사실에 놀랐다. 대표적인 예로 AB (Abdominal의 약자), BAA (양의 울음 소리), AA (용암의 종류), ABBA (스웨덴 팝 그룹)이 있다.
//
//이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다. 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다. 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.
//
//문자열의 뒤에 A를 추가한다.
//문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
//주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)
//
//출력S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.
//
//예제 입력 1
//A
//BABA
//예제 출력 1
//1
//예제 입력 2
//BAAAAABAA
//BAABAAAAAB
//예제 출력 2
//1
//예제 입력 3
//A
//ABBA
//예제 출력 3
//0
//
//[위 문제를 저는 아래 코드로 만들었습니다만 시간 제한 2초 메모리제한 512MB에 걸리는데요 코드를 검토해보고 고쳐야 할 점을 알려주세요.]
//* */
//
//package DFS;
//import java.util.*;
//import java.io.*;
//
//public class BOJ_12919 {
//    static boolean visited[];
//    static boolean check;
//    public static void main(String[] args) throws Exception{
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
//        String S = tk.nextToken();
//        tk = new StringTokenizer(in.readLine()," ");
//        String T = tk.nextToken();
//        visited = new boolean[50];
//        DFS(S,T,0);
//        if(!check)
//        {
//            System.out.println(0);
//        } else {
//            System.out.println(1);
//        }
//    }
//    private static String Reverse(String str){
//        String s = "";
//        for(int i = str.length() - 1; i >= 0 ; i--){
//            s += str.charAt(i) + "";
//        }
//        return s;
//    }
//    private static void DFS(String s, String t, int idx) {
//
//        if(s.equals(t)){
//            check = true;
//            return;
//        }
//
//        if(t.length() == s.length()){
//            return ;
//        }
//
//        if(!visited[idx]) {
//            visited[idx] = true;
//
//            String temp =  s + "A";
//            DFS(temp, t, idx + 1);
//            visited[idx] = false;
//
//            temp = Reverse(s + "B");
//            DFS(temp, t, idx + 1);
//        }
//        return ;
//    }
//
//}
package BOJ.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        canTransform(S,T);

        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void canTransform(String S, String T) {
        if (S.length() >= T.length()) {
            if (S.equals(T)) {
                check = true;
            }
            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            T = T.substring(0, T.length() - 1);
            System.out.println(T);
            canTransform(S,T);
        }

        if (T.charAt(0) == 'B') {
            T = reverseString(T.substring(1));
            System.out.println(T);
            canTransform(S, T);

        }

    }
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

}