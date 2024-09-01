package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22857 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        int[] S = new int[N];
        for (int i = 0; i < N; i++){
            S[i] = Integer.parseInt(tk.nextToken());
        }
        // Sliding Window 방식으로 판단
        // 홀수가 나왔을 때 K 만큼을 뺄 수 있음을 유의하자
        // 현재 최장 부분 수열은 오른쪽 끝에서 왼쪽 끝까지 탐색 중에 홀 수 케이스로 검출 된 케이스를 제외 한 것들에 대해서 체크 가능하다.

        int oddCount = 0;
        int left = 0;
        int max = 0;
        for (int right = 0; right < N; right++){
            if(S[right] % 2 != 0){
                oddCount++;
            }
            while (oddCount > K){
                if(S[left] % 2 != 0){ //현재 상태에서 왼쪽 방향의 조건이 홀수 일 경우 oddCount를 내리고 left Case를 상승 시킴
                    oddCount--;
                }
                left++; //즉, 하나를 버리고 상승함
            }
            max = Math.max(max, (right - left + 1) - oddCount);
        }
        System.out.println(max);
    }
}
