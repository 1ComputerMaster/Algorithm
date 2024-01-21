package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1456 {
    static Set<Long> set;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        long A = Long.parseLong(tk.nextToken());
        long B = Long.parseLong(tk.nextToken());

        set = new HashSet<>();
        isPrime = new boolean[(int) Math.sqrt(B) + 1];

        getPrime();

        for (long i = 2; i * i <= B; i++) {
            if (isPrime[(int) i]) {
                long num = i * i;
                while (num <= B) {
                    if (num >= A) {
                        set.add(num);
                    }
                    if (num > Long.MAX_VALUE / i) {
                        break;
                    }
                    num *= i;
                }
            }
        }

        System.out.println(set.size());
    }

    private static void getPrime() {
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}