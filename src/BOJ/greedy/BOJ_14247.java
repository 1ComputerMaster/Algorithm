package BOJ.greedy;

import java.util.*;

public class BOJ_14247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> A = new ArrayList<>();
        long answer = 0L;
        for (int i = 0; i < n; i++){
            answer += sc.nextLong();
        }
        for (int i = 0; i < n; i++){
            A.add(sc.nextLong());
        }
        Collections.sort(A);
        for (int j = 0; j < n; j++){
            answer += A.get(j) * j;
        }

        System.out.println(answer);
    }
}
