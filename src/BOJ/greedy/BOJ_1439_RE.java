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

        for (int i = 0; i < crr.length; i++){
            if(crr[i] == '1' && start != crr[i]){
                oneCnt++;
                start = crr[i];
            }
            if(crr[i] == '0' && start != crr[i]){
                zeroCnt++;
                start = crr[i];
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));
    }
}
