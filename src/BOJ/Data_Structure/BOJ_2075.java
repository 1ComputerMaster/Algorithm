package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < N; j++){
                pq.add(Integer.parseInt(tk.nextToken()));
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }
        System.out.println(pq.poll());
    }
}
