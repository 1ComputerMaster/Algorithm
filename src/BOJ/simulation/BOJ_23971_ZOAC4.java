package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_23971_ZOAC4 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        double H = Integer.parseInt(tk.nextToken());
        double W = Integer.parseInt(tk.nextToken());
        double N = Integer.parseInt(tk.nextToken());
        double M = Integer.parseInt(tk.nextToken());
        int h = (int) (Math.ceil(H/(N+1)));
        int w = (int) (Math.ceil(W/(M+1)));

        System.out.println(h*w);

    }

}