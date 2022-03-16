package simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_KAKAO_신고_결과_받기 {
	public static void main(String[] args) {
		int[] ans = solution(new String[] {"muzi", "frodo", "apeach", "neo"},new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}System.out.println();
	}
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String reporter = "";
        String enemy = "";
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<String>> person = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            StringTokenizer tk = new StringTokenizer(report[i]," ");
            reporter = tk.nextToken();
            enemy = tk.nextToken();
            if(person.get(enemy) != null)
            {
            	if(person.get(enemy).contains(reporter)) {
            		continue;
            	}else {
            		person.get(enemy).add(reporter);
            	}
            }else {
            	ArrayList<String> str = new ArrayList<>();
            	str.add(reporter);
            	person.put(enemy, str);
            }
            if(map.get(enemy) == null){
                map.put(enemy,1);
            }else{
                map.put(enemy,map.get(enemy)+1);
            }
        }
        for (String key : map.keySet()) {
        	if(map.get(key) >= k) {
				for(int j = 0; j < id_list.length; j++){
					for (int i = 0; i < person.get(key).size(); i++) {
						if(id_list[j].equals(person.get(key).get(i))) {
	        				answer[j] += 1;
	        			}
					}
        		}
			}
		}
        return answer;
	}
}
