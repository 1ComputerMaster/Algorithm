package BOJ.greedy;

import java.util.Scanner;

public class BOJ_13413 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int N = sc.nextInt();
            String src = sc.next();
            String dest = sc.next();

            // mismatchBW: src에서 B, dest에서 W인 위치 개수
            // mismatchWB: src에서 W, dest에서 B인 위치 개수
            int mismatchBW = 0;
            int mismatchWB = 0;

            for(int i=0; i<N; i++){
                if(src.charAt(i) == 'B' && dest.charAt(i) == 'W') mismatchBW++;
                else if(src.charAt(i) == 'W' && dest.charAt(i) == 'B') mismatchWB++;
            }
            // 최소 작업 횟수 = max(mismatchBW, mismatchWB)
            System.out.println(Math.max(mismatchBW, mismatchWB));
        }
    }
}