package LeetCode;
import java.util.*;
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }
    public static boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        // 각 문자(ASCII 코드 0~255)에 대해
        // mapS2T[c] = s문자 c가 매핑된 t문자의 ASCII 코드+1
        // mapT2S[c] = t문자 c가 매핑된 s문자의 ASCII 코드+1
        int[] mapS2T = new int[256];
        int[] mapT2S = new int[256];

        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // 아직 매핑이 없으면(mapS2T[cs]==0)
            if (mapS2T[cs] == 0 && mapT2S[ct] == 0) {
                // 서로 연결
                mapS2T[cs] = ct + 1;
                mapT2S[ct] = cs + 1;
            }
            else {
                // 이미 매핑이 존재한다면, 기존 매핑과 일치하는지 확인
                if (mapS2T[cs] != ct + 1 || mapT2S[ct] != cs + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
