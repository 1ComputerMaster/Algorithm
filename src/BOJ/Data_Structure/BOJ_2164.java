package BOJ.Data_Structure;
import java.util.*;
import java.io.*;

public class BOJ_2164 {
    public static void main(String[] args) throws Exception{
        Queue<Integer> q = new LinkedList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        int ans = 0;
        while(!q.isEmpty()){
            ans = q.poll();
            if(!q.isEmpty()){
                int tmp = q.poll();
                q.add(tmp);
            }
        }
        System.out.print(ans);
    }
}
