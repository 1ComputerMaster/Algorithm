package BOJ.simulation;
import java.util.*;
import java.io.*;

public class BOJ_1205_등수_구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int point = Integer.parseInt(tk.nextToken());
        int P = Integer.parseInt(tk.nextToken());
        List<Integer> list = new ArrayList<>();
        if(N == 0){
            if(P > 0){
                System.out.println(1);
            }else{
                System.out.println(-1);
            }
        }else{
            tk = new StringTokenizer(in.readLine()," ");
            int n = 0;
            list.add(point);
            for(int i = 0; i < N; i++)
            {
                list.add(Integer.parseInt(tk.nextToken()));
            }

            Collections.sort(list, (o1,o2) -> o2.compareTo(o1));
            n = list.indexOf(point);
            if(list.lastIndexOf(point) >= P){
                System.out.println(-1);
            }else{
                System.out.println(n+1);
            }
        }
    }
}
