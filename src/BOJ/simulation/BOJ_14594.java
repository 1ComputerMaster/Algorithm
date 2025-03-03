package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14594 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        int M = Integer.parseInt(tk.nextToken());
        boolean[] rooms = new boolean[N];
        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int start = Integer.parseInt(tk.nextToken()) - 1;
            int end = Integer.parseInt(tk.nextToken()) - 1;
            for (int j = end; j > start; j--){
                rooms[j] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++){
            if(!rooms[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
