package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    static class Lecture implements Comparable<Lecture>{
        int start, end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) return this.end - o.end;
            else return this.start - o.start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Lecture lecture : lectures){
            if(!pq.isEmpty() && pq.peek() <= lecture.start) pq.poll();
            pq.offer(lecture.end);
        }
        System.out.println(pq.size());
    }
}

