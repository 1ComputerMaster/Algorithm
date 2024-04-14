package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21758 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        List<Integer> list = new ArrayList<Integer>();
        List<Long> leftTotalSum = new ArrayList<Long>();
        List<Long> rightTotalSum = new ArrayList<Long>();

        long right = 0;
        for (int i = 0; i < N; i++){
            int place = Integer.parseInt(tk.nextToken());
            list.add(place);
            right += place;
            rightTotalSum.add(right);
        }
        long left = 0;
        for (int i = N - 1; i >= 0; i--){
            left += list.get(i);
            leftTotalSum.add(left);
        }
        long ans = 0;

        //벌통 왼쪽 고정 - 벌1 오른쪽 고정
        long bee1, bee2;			// 벌 1, 벌 2의 꿀 채집량
        bee2 = 0;
        for (int i = N - 2; i >= 1; i--) {
            bee1 = right - list.get(N - 1) - list.get(i);
            bee2 = right - leftTotalSum.get(N - i - 1);
            ans = Math.max(ans, bee1 + bee2);
        }


        //벌통 오른쪽 고정 - 벌1 왼쪽 고정
        for (int i = 1; i <= N - 2; i++) {
            bee1 = right - list.get(i) - list.get(0);
            bee2 = right - rightTotalSum.get(i);
            ans = Math.max(ans, bee1 + bee2);
        }

        //벌1, 벌2 양쪽마다 고정 - 벌통 위치 place 둠
        for (int i = 1; i < N - 1; i++){
            bee1 = leftTotalSum.get(N - i - 1) - list.get(N - 1);
            bee2 = rightTotalSum.get(i) - list.get(0);
            ans = Math.max(ans, bee1 + bee2);
        }
        System.out.println(ans);
    }
}
