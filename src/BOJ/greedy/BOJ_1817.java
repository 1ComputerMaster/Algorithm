package BOJ.greedy;
import java.util.*;

class BOJ_1817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); //각 가방별 최대 무게
        int[] bag = new int[N];
        int bagCount = 0;
        for (int i = 0; i < N; i++){
            int weightNow = sc.nextInt();
            if(bag[bagCount] + weightNow > M){
                bag[++bagCount] += weightNow;
            }else{
                bag[bagCount] += weightNow;
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(bag[i] == 0){
                cnt = i;
                break;
            }
        }
        System.out.println(cnt == 0 ? N : cnt);
    }
}