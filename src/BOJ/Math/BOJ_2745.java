package BOJ.Math;

import java.util.Scanner;

public class BOJ_2745 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String B = sc.next();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(B);
        B = sb.reverse().toString();
        int sum = 0;
        int num = 1; //자릿수
        char crr[] = B.toCharArray();
        for (char c : crr){
            if('A' <= c && 'Z' >= c ){
                sum += (c - 'A' + 10) * num;
            }else{
                int n = (c - '0') * num;
                sum += n;
            }
            num *= N;
        }
        System.out.println(sum);
    }
}
