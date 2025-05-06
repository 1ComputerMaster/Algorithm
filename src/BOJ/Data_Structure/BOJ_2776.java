package BOJ.Data_Structure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2776 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(in.readLine());
        while (T-- > 0){
            Map<Integer, Integer> map = new HashMap<>();
            int N = Integer.parseInt(in.readLine());
            String[] str = in.readLine().split(" ");
            for (int i = 0; i < N; i++){
                map.put(Integer.parseInt(str[i]), 1);
            }

            int M = Integer.parseInt(in.readLine());
            str = in.readLine().split(" ");
            for (int i = 0; i < M; i++){
                sb.append(map.containsKey(Integer.parseInt(str[i])) ? 1 + "\n" : 0 + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
