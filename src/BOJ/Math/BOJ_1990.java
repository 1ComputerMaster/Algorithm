package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1990 {
    static boolean [] isPrime;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        isPrime = new boolean[b + 1];
        getPrime();
        getAns(a);
        System.out.println(-1);

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
    private static void getAns(int a){
        StringBuffer sb = new StringBuffer();
        for (int i = a; i < isPrime.length; i++){
            if(isPrime[i] == true){
                sb.append(i);
                if(sb.reverse().toString().equals(String.valueOf(i))){
                    System.out.println(i);
                }
                sb = new StringBuffer();
            }
        }
    }
}
