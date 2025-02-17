package BOJ.greedy;

import java.util.Scanner;

public class BOJ_1439_RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        char[] crr = S.toCharArray();
        char start = crr[0];

        int oneCnt = 0, zeroCnt = 0;

        if(start == '1'){
            oneCnt++;
        }else{
            zeroCnt++;
        }

        for (char c : crr) {
            if (c == '1' && start != c) {
                oneCnt++;
                start = c;
            }
            if (c == '0' && start != c) {
                zeroCnt++;
                start = c;
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));
    }
}
