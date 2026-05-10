package BOJ.simulation;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1000_AplusB {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        int ans = a + b;
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

}
