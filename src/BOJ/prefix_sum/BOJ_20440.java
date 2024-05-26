package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20440 {
    static class Time {
        int s, e;
        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    static int n;
    static Time[] time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        time = new Time[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[i] = new Time(start, end);
        }
        Arrays.sort(time, Comparator.comparingInt(o -> o.s)); //시작 지점으로 오름차순 정렬 진행

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //PriorityQueue Endpoint로 오름차순 정렬 진행
        int cnt = 1;
        int s = time[0].s;
        int e = time[0].e;
        pq.add(e);

        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() < time[i].s) { //만일 스타트 지점이 이전 엔드포인트와 끊긴 경우라면...
                pq.poll(); //연결된 지점이 더 이상 아니므로 poll으로 꺼낸다.
                //연결된 지점임을 확정 할 수 있는 이유는 PriorityQueue가 end를 오름 차순으로 정렬했기 때문이다.
            }
            if (!pq.isEmpty() && pq.peek() == time[i].s) {  //만일 스타트 지점이 현재 queue의 엔드포인트와 같다면
                if (pq.peek() == e) { //위에서 poll으로 빠진 경우 체크
                    e = time[i].e; //e는 항상 업데이트를 해준다.
                }
                pq.poll(); //queue에서 하나 빼고 다시 넣는 로직
            }
            pq.add(time[i].e); //endpoint 삽입
            if (pq.size() > cnt) { //만일 size() 갱신이 된다면...
                cnt = pq.size();
                s = time[i].s; //시작 지점이 바뀌었을 것이다. 왜냐하면 한 번 더 들어온 경우니 사이즈가 늘었다...!
                e = pq.peek(); //e도 새로 갱신
            }
        }
        System.out.println(cnt);
        System.out.println(s + " " + e);

    }
}

