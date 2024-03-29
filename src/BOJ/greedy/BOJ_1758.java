package BOJ.greedy;

import java.util.*;

public class BOJ_1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < N; i++){
            arr.add(sc.nextLong());
        }
        arr.sort(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0; i < arr.size(); i++){
            ans += Math.max((arr.get(i) - i), 0);
        }
        System.out.println(ans);
    }
}
