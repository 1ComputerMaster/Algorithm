package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1669 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (x == y) {
            System.out.println(0);
            return;
        }
        int diff = y-x;

        if(Math.pow((int)Math.sqrt(diff), 2) == diff)
        {
            System.out.println((long)(2 * (long)(Math.sqrt(diff)) - 1));
        }else{
            long num = (long) Math.pow((int)Math.sqrt(diff), 2);
            long num2 = (long) Math.pow((int)Math.sqrt(num) + 1 , 2);
            if(Math.abs(num - diff) < Math.abs(num2 - diff)){
                System.out.println((long)(2 * ((int)Math.sqrt(diff)) - 1) + 1);
            }else{
                System.out.println((long)(2 * ((int)Math.sqrt(diff)) - 1) + 2);
            }
        }
    }
}