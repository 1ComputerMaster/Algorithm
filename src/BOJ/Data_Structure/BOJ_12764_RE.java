package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12764_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] com = new int[N][2];


        StringTokenizer tk;
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine());
            com[i][0] = Integer.parseInt(tk.nextToken());
            com[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(com, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> freedSeat = new PriorityQueue<>();
        List<Integer> usingCount = new ArrayList<>();

        solve(occupiedSeats, freedSeat, usingCount, com);

        System.out.println(usingCount.size());
        for (int i = 0; i < usingCount.size(); i++){
            System.out.print(usingCount.get(i) + " ");
        }
    }

    private static void solve(PriorityQueue<int[]> occupiedSeats, PriorityQueue<Integer> freeSeats, List<Integer> usingCount, int[][] com) {
        for (int[] time : com){
            int start = time[0];
            int end = time[1];
            while(!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] < start){
                int freedSeat = occupiedSeats.poll()[1]; //현재 시트는 빈자리임
                freeSeats.add(freedSeat); //이거 빈자리로 만들자
            }
            int seat;
            if(freeSeats.isEmpty()){
                seat = usingCount.size();
                usingCount.add(0);
            }else {
                seat = freeSeats.poll();
            }
            usingCount.set(seat, usingCount.get(seat) + 1);
            occupiedSeats.add(new int[]{end, seat});
        }
    }
}
