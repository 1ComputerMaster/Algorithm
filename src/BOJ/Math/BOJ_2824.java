package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2824 {
    static List<Integer> AList;
    static List<Integer> BList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        AList = new ArrayList<>();
        BList = new ArrayList<>();
        tk = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            AList.add(Integer.parseInt(tk.nextToken()));
        }
        tk = new StringTokenizer(in.readLine(), " ");
        int M = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < M; i++) {
            BList.add(Integer.parseInt(tk.nextToken()));
        }
        long num = 1;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int gcd = GCD(AList.get(i), BList.get(j));
                num *= gcd;
                if(num >= 1000_000_000){
                    check = true;
                }
                num %= 1000_000_000;

            }
        }
        if(check)
        {
            System.out.printf("%09d\n", num);
        }else{
            System.out.println(num);
        }

    }

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
