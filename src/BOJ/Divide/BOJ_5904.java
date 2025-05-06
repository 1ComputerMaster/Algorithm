package BOJ.Divide;

import java.io.*;

public class BOJ_5904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(findCharacter(N));
    }

    private static String findCharacter(int n) {
        int k = 0;
        long len = 3;
        if (n <= 3) {
            return n == 1 ? "m" : "o";
        }

        while (len < n) {
            k++; //단계 상승
            len = (len * 2 + k + 3);
        }
        //이전 길이 : 현재가 S(K+1)이면 S(K)의 길이만 구함
        long prevLen = (len - (k + 3)) / 2;

        if (n <= prevLen) {
            return findCharacter(n);
        } else if (n <= len - prevLen) {
            return n == prevLen + 1 ? "m" : "o";
        } else {
            return findCharacter((int)(n - (prevLen + k + 3)));
        }
    }
}