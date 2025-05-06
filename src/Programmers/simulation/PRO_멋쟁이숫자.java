package Programmers.simulation;

import java.util.Scanner;

public class PRO_멋쟁이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tmp;
        int ans = -1;
        for (int i = 0; i < str.length(); i++){
            if(i + 3 < str.length()) {
                tmp = (str.substring(i, i + 3));
                for (int k = 0; k < tmp.length(); k++){
                    if(tmp.charAt(k) != tmp.charAt(0)){
                        break;
                    }
                }
                ans = Math.max(ans, Integer.parseInt(tmp));
            }
        }
        System.out.println(ans);
    }
}
