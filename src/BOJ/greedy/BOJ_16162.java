package BOJ.greedy;

import java.util.Scanner;

public class BOJ_16162 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 참가자들의 음 개수
        int A = sc.nextInt(); // 시작 음
        int D = sc.nextInt(); // 공차

        int count = 0;  // 등차수열에 해당하는 음의 개수
        int target = A; // 현재 찾아야 할 음

        // 음들이 순서대로 주어짐
            for(int i = 0; i < N; i++){
            int note = sc.nextInt();
            if(note == target){
                count++;
                target += D;
            }
        }
            System.out.println(count);
    }
}