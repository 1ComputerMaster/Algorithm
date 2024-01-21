package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14675 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        tk = new StringTokenizer(in.readLine(), " ");

        int Q = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine(), " ");
            int t = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken());
            if(t == 2){
                System.out.println("yes");
            }else{
                if(list[k].size() == 1 || list[k].size() == 0){
                    System.out.println("no");
                }else{
                    System.out.println("yes");
                }
            }
        }
    }
}
