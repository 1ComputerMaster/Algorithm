package BOJ.simulation;

import java.util.Scanner;

public class BOJ_2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long max = 1;
        int ans = 1;
        while(max < N){
            max += 6*ans;
            ans++;
        }
        System.out.println(ans);
    }
}
