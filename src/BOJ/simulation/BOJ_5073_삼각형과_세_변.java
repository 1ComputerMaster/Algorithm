package BOJ.simulation;

import java.util.Scanner;

public class BOJ_5073_삼각형과_세_변{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 0 && b == 0 && c == 0){
                return;
            }
            int max = Math.max(a, Math.max(a, c));

            System.out.println(change(max, a, b, c));

        }

    }
    public static String change(int max, int a, int b, int c){
        if(max < (a + b + c) - max){
            if(a == b && b == c){
                return "Equilateral";
            }else if((a == b && b != c) || (a == c && c != b) || (b == c && a != b)){
                return "Isosceles";
            }else{
                return "Scalene";
            }
        }
        return "Invalid";
    }
}