package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10025 {
    /*
    배열을 사용하여 푸는 것이 더 좋을 것 같습니다.
    PriorityQueue를 활용한 풀이보다 for 문을 사용해서 배열로 윈도우 사이즈 만큼 이동 시킨 것이 40ms 정도 성능 효율이 좋았습니다.
     */
    static class Ice implements Comparable<Ice>{
        int gram;
        int where;
        public Ice(int gram, int where){
            this.gram = gram;
            this.where = where;
        }

        @Override
        public int compareTo(Ice o) {
            return Integer.compare(this.where, o.where);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        PriorityQueue<Ice> pq = new PriorityQueue<Ice>();
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            int gram = Integer.parseInt(tk.nextToken());
            int where = Integer.parseInt(tk.nextToken());
            pq.add(new Ice(gram, where));
        }
        List<Ice> windowList = new ArrayList<>();
        int prefixSum = 0;
        int left = 0;
        int ans = 0;
        while (!pq.isEmpty()){
            Ice now = pq.poll();
            prefixSum += now.gram;
            windowList.add(now);
            while (windowList.get(left).where < now.where - K * 2) {
                prefixSum -= windowList.get(left).gram;
                left++;
            }
            ans = Math.max(ans, prefixSum);
        }
        System.out.println(ans);
    }
}
