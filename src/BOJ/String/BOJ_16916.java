package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        String P = in.readLine();
        if(S.contains(P)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
