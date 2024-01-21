package Programmers.Queue;
import java.util.*;
public class PRO_기능개발 {

	public static void main(String[] args) {
		int[] pro = {95, 90, 99, 99, 80, 99};
		int[] sp = {1,1,1,1,1,1};
		System.out.println(Arrays.toString(solution(pro,sp)));
	}
	  public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        ArrayList<Integer> ans = new ArrayList<>();
	        int[] count = new int[progresses.length];
	        Queue<Integer> st = new LinkedList<>();
	        for(int i = 0; i < progresses.length; i++){
	            int temp = progresses[i];
	            while(temp < 100){
	                count[i]++;
	                temp += speeds[i];
	            }
	            if(st.isEmpty()) {
	            	st.add(count[i]);
	            }
	            else {
	            	if(st.peek() >= count[i]) {
	            		st.add(count[i]);
	            	}else {
	            		ans.add(st.size());
	            		st.clear();
	            		st.add(count[i]);
	            	}
	            }
	        }
	        if(!st.isEmpty()) {
	        	ans.add(st.size());
	        	st.clear();
	        }
	        answer = new int[ans.size()];
	        for(int i = 0; i < ans.size();i++) {
	        	answer[i] = ans.get(i);
	        }
	        return answer;
	    }
}
