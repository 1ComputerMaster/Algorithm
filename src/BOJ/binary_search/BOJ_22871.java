package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22871 {
    /*
    * Overflow 주의!
    * - 특이 사항
    * Binary Search와 BFS 조합으로 K가 중점이 되므로 K 값을 기준으로 Binary Search 진행하여
    * 만일, 설정된 K 값으로 끝까지 돌다리 도달 가능하면 K 값을 낮춰서 이진 탐색 진행
    * 그리고, 내부적으로 이진탐색 시 건널 수 있는 가짓수는 BFS로 최소화 함
    * 
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        List<Long> stoneList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            stoneList.add(Long.parseLong(tk.nextToken()));
        }
        long left = 1;
        long result = 0;
        long right =  (N - 1) * (1 + Math.abs(stoneList.get(0) - stoneList.get(N - 1)));
        while (left <= right){
            long mid = (left + right) / 2;
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            boolean[] visited = new boolean[N];
            visited[0] = true;
            while (!q.isEmpty()){
                int start = q.poll();
                for (int i = start + 1; i < N; i++){
                    if(!visited[i] && mid >= (i - start) * (1 + Math.abs(stoneList.get(start) - stoneList.get(i)))){
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
            if(!visited[N - 1]){
                left = mid + 1;
            }else {
                right = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
