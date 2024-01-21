package BOJ.simulation;

import java.util.Scanner;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N%2 == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
