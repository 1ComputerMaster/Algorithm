package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15552 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(tk.nextToken());
        while(T-- > 0){
            tk = new StringTokenizer(in.readLine()," ");
            sb.append(Integer.parseInt(tk.nextToken()) + Integer.parseInt(tk.nextToken()) + "\n");
        }
        System.out.println(sb);
    }
}
