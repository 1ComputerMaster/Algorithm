package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_30468 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(" ");

        int cnt = 0;

        for (int i = 0; i < 4; i++){
            cnt += Integer.parseInt(str[i]);
        }

        int N = Integer.parseInt(str[4]);
        int ans = 0;
        while (cnt / 4 < N){
            cnt+=1;
            ans += 1;
        }
        System.out.println(ans);
    }
}
