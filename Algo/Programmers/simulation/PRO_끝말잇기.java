package simulation;

import java.util.*;

public class PRO_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            list.add(words[i]); //넣기
        }
        String s = "";
        String s1 = "";
        char temp;
        for(int i = 0; i < list.size() - 1; i++){
            
            s = list.get(i);
            temp = s.charAt(s.length()-1);
            s1 = list.get(i + 1);
            if(temp == s1.charAt(0))
            {
                for(int j = i; j >= 0; j--){
                    if(i == 0 || j == i){
                        continue;
                    }else{
                        if(list.get(j).equals(s1)){ // 부른 것과 같다면
                            answer[1] = (int)Math.ceil((double)(i+2)/(double)n);
                            if((i+2)%n == 0){
                                answer[0] = n; 
                            }else{
                                answer[0] = (i+2)%n;
                            }
                            return answer;
                        } 
                    }
                }
            }else{ //여기서 부터 아닌 것
                 
                if((i+2)%n == 0){
                    answer[0] = n; 
                }else{
                    answer[0] = (i+2)%n;
                }
                answer[1] = (int)Math.ceil((double)(i+2)/(double)n);
                return answer;
            }
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}
