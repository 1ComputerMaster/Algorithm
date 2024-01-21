package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15663 {
    static int N,M;
    static int num[];
    static int arr[];
    static StringBuilder sb;

    static Set<String> ans;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        num = new int[N];
        arr = new int[M];
        ans = new LinkedHashSet<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(num);
        go(0,0);
        ans.stream().forEach(i -> sb.append(i));
        System.out.println(sb.toString());
    }

    private static void go(int idx,int start) {
        if(idx == M){
            String tmp = "";
            for(int i = 0; i < M; i++){
                tmp += String.valueOf(arr[i]) + " ";
            }
            tmp += "\n";
            ans.add(tmp);
            return;
        }
        for(int i = start; i < N; i++){
            arr[idx] = num[i];
            go(idx + 1, i);
        }
    }
}
