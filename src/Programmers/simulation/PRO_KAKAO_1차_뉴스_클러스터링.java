package simulation;

import java.util.*;
public class PRO_KAKAO_1차_뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String temp = "";
    for(int i = 0; i < str1.length() - 1; i++) {
    	temp = str1.substring(i, i+2).toUpperCase();
    	if(((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) && (temp.charAt(1) >= 65 && temp.charAt(1) <= 90)) || ((temp.charAt(0) >= 97 && temp.charAt(0) <= 122) && (temp.charAt(1) >= 97 && temp.charAt(1) <= 122)))
    		list1.add(temp);
    }
    for(int i = 0; i < str2.length() - 1; i++) {
    	temp = str2.substring(i, i+2).toUpperCase();
    	if(((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) && (temp.charAt(1) >= 65 && temp.charAt(1) <= 90)) || ((temp.charAt(0) >= 97 && temp.charAt(0) <= 122) && (temp.charAt(1) >= 97 && temp.charAt(1) <= 122)))
    		list2.add(temp);
    }
    boolean check[] = new boolean[list2.size()];
    int cnt = 0;
    for(int i = 0; i < list1.size(); i++) {
    	temp = list1.get(i);
    	for(int j = 0; j < list2.size(); j++) {
    		if(check[j] == false) {
    			if(temp.equals(list2.get(j))) {
    				cnt++; //교집합 카운트
    				check[j] = true; // 여기 다시 못 보게
                        break;
        			}
        		}
        	}
        }
        int all = list1.size() + list2.size();
        double ans;
        if(all != 0) {
        	ans = (double)cnt/(double)(all - cnt);
            ans *= 65536;
        }else {
        	return 65536;
        }
        answer = (int) ans;
        return answer;
    }
}

