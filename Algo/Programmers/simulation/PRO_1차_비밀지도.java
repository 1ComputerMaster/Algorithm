package simulation;
import java.util.*;

public class PRO_1차_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char arr[][] = new char[n][n];
        for(char[] crr : arr){
            Arrays.fill(crr,' ');
        }
        
        int temp = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            temp = arr1[i];
            cnt = n - 1;
            while(temp > 0){
                if((temp%2) == 1){
                    arr[i][cnt] = '#';
                }
                temp/=2;
                cnt--;
            }
            temp = arr2[i];
            cnt = n - 1;
            while(temp > 0){
                if((temp%2) == 1){
                    arr[i][cnt] = '#';
                }
                temp/=2;
                cnt--;
            }
        }
        for(int i = 0; i < n; i++){
            answer[i] = "";
            for(int j = 0; j < n; j++){
                answer[i] += arr[i][j];
            }
        }
        return answer;
    }
}
