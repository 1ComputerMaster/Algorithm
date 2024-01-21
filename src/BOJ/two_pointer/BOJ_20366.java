package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20366 {
    static int ans = Integer.MAX_VALUE;
    static List<Integer> snowList;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        snowList = new ArrayList<Integer>();
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < N; i++){
            snowList.add(Integer.parseInt(tk.nextToken()));
        }
        Collections.sort(snowList);
        solve(N);
        System.out.println(ans);
    }

    private static void solve(int N) {
        int A = 0;
        int B = 0;
        int S = 0;
        int E = 0;
        for (int i = 0; i < N; i++){
            A = i;
            for (int j = i + 1; j < N; j++){
                S = 0;
                B = j;
                E = N - 1;
                while(S < E){
                    if(S == A || S == B){
                        S++;
                        continue;
                    }
                    if(E == A || E == B){
                        E--;
                        continue;
                    }
                    ans = Math.min(ans, Math.abs((snowList.get(A) + snowList.get(B)) - (snowList.get(S) + snowList.get(E))));
                    if((snowList.get(A) + snowList.get(B)) < (snowList.get(S) + snowList.get(E))) {
                        E--;
                    }
                    else{
                        S++;
                    }
                }
            }
        }
    }
}
