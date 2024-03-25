package BOJ.simulation;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        System.out.println(A.add(B));
    }
}
