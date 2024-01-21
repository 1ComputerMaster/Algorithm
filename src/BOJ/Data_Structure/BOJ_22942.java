package BOJ.Data_Structure;
import java.util.*;
import java.io.*;
public class BOJ_22942 {
    static class Data implements Comparable<Data>{
        int start;
        int end;


        int r;
        public Data(int start, int end, int r){
            this.start = start;
            this.end = end;
            this.r = r;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.start, o.start); //끝 지점끼리 비교
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        PriorityQueue<Data> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            int x = Integer.parseInt(tk.nextToken());

            int r = Integer.parseInt(tk.nextToken());

            pq.add(new Data((x - r),(x + r),r));

        }

        for(int i = 0; i < N; i++){
            Data now = pq.poll();

            int now_d = now.start + now.r;
            if(pq.isEmpty()){
                System.out.println("YES");
                break;
            }else {
                int d = ((pq.peek().r + pq.peek().start) - now_d) * ((pq.peek().r + pq.peek().start) - now_d);
                double dist = Math.sqrt(d);
                if(now.r + pq.peek().r < dist){
                    continue;
                }
                else if(Math.abs(now.r - pq.peek().r) > dist){
                    continue;
                }else if(dist == now.r + pq.peek().r || dist == Math.abs(now.r - pq.peek().r)){
                    System.out.println("NO");
                    break;
                }else{
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
}
