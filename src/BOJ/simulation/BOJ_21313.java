package BOJ.simulation;

import java.util.Scanner;

public class BOJ_21313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean odd = false;

        if(N % 2 == 1){
            odd = true;
            N--;
        }
        while (N > 0){
            if(N % 2 == 0){
                System.out.print("1 ");
            }else{
                System.out.print("2 ");
            }N--;
        }
        if(odd){
            System.out.print("3 ");
        }
    }
}
