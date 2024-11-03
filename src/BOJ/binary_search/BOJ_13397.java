package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13397 {
    static int N,M;
    static List<Integer> numbers;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++){
            numbers.add(Integer.parseInt(tk.nextToken()));
        }
        int left = 0;
        int right = Collections.max(numbers);
        int ans = right;
        while (left <= right){
            int mid = (left + right) / 2;
            if(canIgo(mid) <= M){
                right = mid - 1;
                if (ans > mid)
                {
                    ans = mid;
                }
            }else{
                left = mid + 1;
            }

        }
        System.out.println(ans);
    }
    private static int canIgo(int mid) {
        //각 구간에서 <= mid가 되는지를 검사합니다.
        int t1 = numbers.get(0);
        int t2 = numbers.get(0);
        int ans = 1;
        for (int i = 1; i < numbers.size(); i++) {
            if (t1 > numbers.get(i)) { //최소 값을 갱신
                t1 = numbers.get(i);
            }
            if (t2 < numbers.get(i)) { //최대값을 갱신
                t2 = numbers.get(i);
            }
            if (t2 - t1 > mid) { //배열의 바운더리라서 더 큰지로 판단을 함
                // 이미 이전에 t1, t2 데이터가 셋팅이 되었기 때문에 위 로직으로 판단
                ans += 1;
                t1 = numbers.get(i);
                t2 = numbers.get(i);
            }
        }
        return ans;
    }
}
