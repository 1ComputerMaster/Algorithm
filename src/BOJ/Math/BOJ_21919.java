package BOJ.Math;
import java.util.*;

public class BOJ_21919 {
    private static long gcd(long a, long b) {
        if(b == 0)
        {
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static long lcmOfPrimes(List<Long> primes) {
        long lcm = 1L;
        for (int i = 0; i < primes.size(); i++) {
            lcm *= primes.get(i) / gcd(lcm, primes.get(i));
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] A = new long[N];

        // 소수들 저장
        List<Long> primes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();

            // 소수일 경우 primes 배열에 추가
            if (isPrime(A[i])) {
                primes.add(A[i]);
            }
        }

        // 소수가 하나도 없으면 -1 출력
        if (primes.size() == 0) {
            System.out.println(-1);
        } else {
            // 소수들의 최소공배수 출력
            System.out.println(lcmOfPrimes(primes));
        }
    }
}
