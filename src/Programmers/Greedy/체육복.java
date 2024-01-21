package Programmers.Greedy;
import java.util.Arrays;
class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
       int answer = (n-lost.length);
        int a = lost.length;//잃어버린 놈들 길이
        int b = reserve.length;//가지고 있는 놈들 길이
        int len;
        for(int i = 0;i<lost.length;i++){
            for(int j = 0;j<reserve.length;j++){
                if(lost[i] == reserve[j]){ //여벌의 체육복 가진놈이 훔침 당할 수 있다는 조건이 존재함
                    lost[i] = reserve[j] = -1; //고로 얘는 다시 탐색 못하게 막음
                    answer++; // 위에서 lost.length 만큼 지웠는데 알고보니 얘는 여벌이 있으니 answer++ 해준다.
                    break;
                }
            }
        }
         for(int i = 0;i<lost.length;i++){
            for(int j = 0;j<reserve.length;j++){
                if(lost[i]-1 == reserve[j])
                {
                    lost[i]=reserve[j] = -1; //중요!! lost[i]도 예외 처리를 해주어야 하는 이유가 얘가 만약 그대로이면 
                                            //뒤에 else if가 돌 수도 있다.
                    answer++;
                    break;//어쨌든 둘 중에 하나가 answer로 들어가면 i번째의 경우는 빌린 것이 되므로 더이상 탐색을 멈춘다.
                }
                else if(lost[i]+1 == reserve[j]){
                    lost[i]=reserve[j] = -1;
                    answer++;
                    break;
                }
            }
         }
        return answer;
    }
}