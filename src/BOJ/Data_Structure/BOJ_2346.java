package BOJ.Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2346 {
    static class Balloon {
        int idx; // 풍선 번호
        int value; // 적혀있는 값

        public Balloon(int idx, int value) {
            this.idx=idx;
            this.value=value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int N = Integer.parseInt(str);
        str = in.readLine();
        Deque<Balloon> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String[] srr = str.split(" ");
        for(int i = 0; i < N; i++) {
            dq.add(new Balloon(i,Integer.parseInt(srr[i])));
        }

        while(N-- > 0) {

            sb.append(dq.getFirst().idx + 1+" ");

            int go = dq.poll().value;

            if(dq.isEmpty()){
                break;
            }

            if(go > 0) {
                for(int i = 0; i < go - 1; i++)
                    dq.addLast(dq.pollFirst());
            }
            else {
                for(int i = 0; i < Math.abs(go); i++)
                    dq.addFirst(dq.pollLast());
            }
        }
        System.out.println(sb.toString());
    }
}
