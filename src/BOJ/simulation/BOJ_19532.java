package BOJ.simulation;

import java.util.Scanner;

public class BOJ_19532 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        for(int x = -999; x <= 999; x++){
            for(int y = -999; y <= 999; y++){
                if(c == (a*x + b*y) && (d*x + e*y) == f){
                    System.out.println(x+ " "+ y);
                    return;
                }
            }
        }
    }
}
