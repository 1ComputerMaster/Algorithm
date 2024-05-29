package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1439 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] S = in.readLine().split("");
        int cnt0 = 0;
        int cnt1 = 0;
        if(S[0].equals("0")){
            cnt0++;
        }else {
            cnt1++;
        }
        for (int i = 1; i < S.length; i++){
            if(!S[i].equals(S[i - 1])){
                if(S[i].equals("0")){
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        System.out.println(Math.min(cnt0,cnt1));
    }
}