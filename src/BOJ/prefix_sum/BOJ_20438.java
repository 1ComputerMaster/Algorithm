package BOJ.prefix_sum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int Q = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N + 3];

        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < K; i++){
            arr[Integer.parseInt(tk.nextToken())] = 2; //sleeper
        }

        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < Q; i++){
            int go = (Integer.parseInt(tk.nextToken()));
            if(arr[go] != 2) {
                arr[go] = 1; //sender
                for (int j = go; j < N + 3; j+= go){
                    if(arr[j] != 2){
                        arr[j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (M-- > 0){
            tk = new StringTokenizer(in.readLine()," ");
            int S = Integer.parseInt(tk.nextToken());
            int E = Integer.parseInt(tk.nextToken());
            int cnt = 0;
            for (int i = S; i <= E; i++){
                if(arr[i] != 1){
                    cnt++;
                }
            }
            sb.append(cnt +"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
