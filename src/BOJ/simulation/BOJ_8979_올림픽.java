package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8979_올림픽 {
    static class Medal implements Comparable<Medal>{
        int idx;
        int g;
        int s;
        int d;
        public Medal (int idx, int g, int s, int d){
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.d = d;
        }
        @Override
        public int compareTo(Medal o) {
            if(this.g==o.g) {
                if(this.s==o.s) {
                    return o.d-this.d;
                }
                else {
                    return o.s-this.s;
                }
            }
            else {
                return o.g-this.g;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int arr[];
        List<Medal> list = new ArrayList<Medal>();
        int ans = 0;
        int kg = 0;
        int ks = 0;
        int kd = 0;
        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            arr = new int[4];
            for(int j = 0; j < 4; j++){
                arr[j] = Integer.parseInt(tk.nextToken());
            }
            Medal medal = new Medal(arr[0], arr[1], arr[2], arr[3]);
            if(arr[0] == K){
                kg = arr[1];
                ks = arr[2];
                kd = arr[3];
            }
            list.add(medal);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).g == kg && list.get(i).s == ks && list.get(i).d == kd){
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }
}
