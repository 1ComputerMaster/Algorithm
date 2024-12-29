package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = in.readLine()) != null) { // null 체크 추가
            if (str.isEmpty()) break; // 빈 문자열 체크
            String s = str.split(" ")[0];
            String t = str.split(" ")[1];
            System.out.println(subStringCheck(s, t) ? "Yes" :"No");
        }
    }

    private static boolean subStringCheck(String s, String t) {
        int nextIndex = 0;
        boolean isSubString;
        for (int j = 0; j < s.length(); j++) {
            isSubString = false;
            for (int i = nextIndex; i < t.length(); i++) {
                if(s.charAt(j) == t.charAt(i)){
                    nextIndex = i + 1;
                    isSubString = true;
                    break;
                }
            }
            if(!isSubString){
                return false;
            }
        }
        return true;
    }
}
