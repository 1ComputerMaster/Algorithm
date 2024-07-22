package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_15663_re {
    static boolean[] visited;
    static int[] num;
    static int[] arr;
    static int N,M;

    static Set<String> strSet;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        visited = new boolean[N];
        num = new int[N];
        arr = new int[M];
        tk = new StringTokenizer(in.readLine()," ");
        strSet = new LinkedHashSet<String>();
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(num);

        backtracking(0);
        StringBuilder sb = new StringBuilder();
        strSet.stream().forEach(e -> sb.append(e + "\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void backtracking(int cnt) {
        if(cnt == M){
            String s = "";
            for (int i = 0; i < M; i++){
                s += (arr[i] + " ");
            }
            strSet.add(s);
            return;
        }
        for (int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = num[i];
                backtracking(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
