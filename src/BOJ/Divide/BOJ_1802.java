package BOJ.Divide;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1802 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            String fold = in.readLine(); // 접힘 정보
            if (isValidFold(fold)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isValidFold(String fold) {
        return checkFold(fold, 0, fold.length() - 1);
    }

    private static boolean checkFold(String fold, int left, int right) {
        if(left >= right){
            return true;
        }
        int mid = (left + right) / 2;
        for(int i = 0; i < mid - left; i++){
            if(fold.charAt(left + i) == fold.charAt(right - i)){
                return false;
            }
        }
        return checkFold(fold, mid + 1, right) && checkFold(fold, left, mid - 1);
    }
}
