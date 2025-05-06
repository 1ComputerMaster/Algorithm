package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16435 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int L = Integer.parseInt(tk.nextToken());
        List<Integer> fruits = new ArrayList<>();
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++){
            fruits.add(Integer.parseInt(tk.nextToken()));
        }
        Collections.sort(fruits);
        for (int i = 0; i < N; i++) {
            if(fruits.get(i) <= L){
                L++;
            }
        }
        System.out.println(L);
    }
}
