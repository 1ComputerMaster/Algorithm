package String;

public class PRO_카카오1_문자열_압축 {
	 public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        String temp;
         int cnt = 0;
         if(s.length()==1) return 1;
         for(int i = 1; i <= s.length()/2; i++){
            temp = s.substring(0,i);
             cnt = 1;
             String reStr = "";
            for(int j = i; j <= s.length() - i; j+=i){
                if(temp.equals(s.substring(j,j+i))){
                    cnt++;
                }else{
                    if(cnt > 1) {
                        reStr += cnt + "";
                    }
                    reStr += temp;
                    temp = s.substring(j,j+i);
                    cnt = 1;
                }
            }
            if(cnt>1) {
    			reStr+= ""+cnt;
    		}
    		reStr+= temp;
    		int div = s.length()%i;
    		answer = Math.min(answer, reStr.length()+div);
        } 
        return answer;
    }
}