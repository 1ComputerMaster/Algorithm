package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19637 {
    static class Data{
        String strength;
        int power;
        public Data(String strength, int power){
            this.power = power;
            this.strength = strength;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        List<Data> list = new ArrayList<>();

        List<Integer> characterList = new ArrayList<>();


        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            list.add(new Data(tk.nextToken(), Integer.parseInt(tk.nextToken())));
        }

        for (int i = 0; i < M; i++){
            tk = new StringTokenizer(in.readLine()," ");
            characterList.add(Integer.parseInt(tk.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = list.size();
            while (left <= right) {
                int mid = (right + left) / 2;
                if (list.get(mid).power >= characterList.get(i)) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            sb.append(list.get(left).strength).append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.append(sb.toString());
        bw.flush();
        bw.close();
    }
}
