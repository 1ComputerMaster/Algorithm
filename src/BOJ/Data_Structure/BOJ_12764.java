package BOJ.Data_Structure;

import java.util.*;

public class BOJ_12764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람의 수
        int[][] times = getTimes(N, sc);

        // 시작 시간을 기준으로 정렬
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        // 우선순위 큐 초기화
        PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // 종료 시간 기준
        PriorityQueue<Integer> freeSeats = new PriorityQueue<>(); // 빈 자리 관리
        List<Integer> usageCounts = new ArrayList<>(); // 자리별 사용 횟수

        // 자리 관리
        solve(times, occupiedSeats, freeSeats, usageCounts);

        // 결과 출력
        System.out.println(usageCounts.size());
        for (int count : usageCounts) {
            System.out.print(count + " ");
        }
    }

    private static void solve(int[][] times, PriorityQueue<int[]> occupiedSeats, PriorityQueue<Integer> freeSeats, List<Integer> usageCounts) {
        for (int[] time : times){
            int start = time[0];
            int end = time[1];

            while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] < start){
                int freedSeat = occupiedSeats.poll()[1]; //현재 시트는 빈자리임
                freeSeats.add(freedSeat); //이거 빈자리로 만들자
            }
            int seat;
            if(freeSeats.isEmpty()){
                seat = usageCounts.size();
                usageCounts.add(0);
            }else{
                seat = freeSeats.poll();
            }
            usageCounts.set(seat, usageCounts.get(seat) + 1);
            occupiedSeats.add(new int[]{end, seat});
        }
    }

    private static int[][] getTimes(int N, Scanner sc) {
        int[][] times = new int[N][2];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            times[i][0] = sc.nextInt(); // 시작 시간
            times[i][1] = sc.nextInt(); // 종료 시간
        }
        return times;
    }
}
