package BOJ.simulation;

import java.util.Scanner;

public class BOJ_14935 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String tmp = "";
        int cnt = 0;
        while (!x.equals(tmp) && cnt != 10000) {
            tmp = x;
            int a = Integer.parseInt(x.charAt(0) + "");
            int size = x.length();
            x = String.valueOf(a * size);
            cnt++;
        }
        if(cnt != 10000) {
            System.out.println("FA");
        }
        else{
            System.out.println("NFA");
        }
    }
}
