package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1946 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int T = Integer.parseInt(tk.nextToken());
        for (int t = 0; t < T; t++){
            tk = new StringTokenizer(in.readLine()," ");
            int N = Integer.parseInt(tk.nextToken());
            int[][] cadidate = new int[N][2];

            for (int i = 0; i < N; i++){
                tk = new StringTokenizer(in.readLine()," ");
                cadidate[i][0] = Integer.parseInt(tk.nextToken());
                cadidate[i][1] = Integer.parseInt(tk.nextToken());
            }

            Arrays.sort(cadidate, Comparator.comparingInt(o -> o[0]));

            int minInterview = cadidate[0][1];
            int cnt = 1;
            for (int i = 1; i < N; i++){
                if (minInterview > cadidate[i][1]){
                    cnt++;
                    minInterview = cadidate[i][1];
                }
            }
            System.out.println(cnt);
        }
    }

}
