package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());

        List<Integer> melody = new ArrayList<Integer>();
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < N; i++){
            melody.add(Integer.parseInt(tk.nextToken()));
        }

        int Q = Integer.parseInt(in.readLine());

        int[] sum = new int[N];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N - 1; i++){
            if(melody.get(i) > melody.get(i + 1)){
                sum[i + 1] = sum[i] + 1;
            }else{
                sum[i + 1] = sum[i];
            }
        }

        while (Q-- > 0) {
            tk = new StringTokenizer(in.readLine(), " ");

            int x = Integer.parseInt(tk.nextToken()) - 1;
            int y = Integer.parseInt(tk.nextToken()) - 1;
            sb.append(sum[y] - sum[x] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
