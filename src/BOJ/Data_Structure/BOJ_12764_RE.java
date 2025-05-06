package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12764_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] times = new int[N][2];


        StringTokenizer tk;
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine());
            times[i][0] = Integer.parseInt(tk.nextToken());
            times[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        solve(times);
    }

    private static void solve(int[][] times) {
        PriorityQueue<int[]> occupiedSeat = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> freedSeat = new PriorityQueue<>();
        List<Integer> usingCount = new ArrayList<>();
        for (int [] time : times){
            int start = time[0];
            int end = time[1];

            while (!occupiedSeat.isEmpty() && occupiedSeat.peek()[0] < start){
                int[] occupied = occupiedSeat.poll();
                freedSeat.add(occupied[1]);
            }

            int seat;

            if(freedSeat.isEmpty()){
                seat = usingCount.size();
               usingCount.add(0);
            } else {
              seat = freedSeat.poll();
            }
            usingCount.set(seat, usingCount.get(seat) + 1);
            occupiedSeat.add(new int[] {end, seat});
        }
        System.out.println(usingCount.size());
        for (Integer count : usingCount) {
            System.out.print(count + " ");
        }
    }

}
