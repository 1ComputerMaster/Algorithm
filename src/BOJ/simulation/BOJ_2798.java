package BOJ.simulation;
import java.io.*;
import java.util.*;
public class BOJ_2798 {
    static int N,M,ans;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        ans = 0;

        tk = new StringTokenizer(in.readLine()," ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(tk.nextToken()));
        }
        for (int i = 0; i < N - 2; i++){
            for(int j = i+1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    if(list.get(i) + list.get(j) + list.get(k) < M){
                        ans = Math.max(ans,list.get(i) + list.get(j) + list.get(k));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
