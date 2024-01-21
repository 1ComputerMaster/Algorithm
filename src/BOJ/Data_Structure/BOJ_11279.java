package BOJ.Data_Structure;
import java.util.*;
import java.io.*;

public class BOJ_11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(in.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(num);
            }
        }
    }
}
