package simulation;

import java.util.Stack;

public class PRO_짝지어_제거하기 {

	public static void main(String[] args) {
		
	}
	public int solution(String s)
	{
		int answer = -1;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(st.isEmpty())
			{
				st.add(s.charAt(i));
			}else {
				if(st.peek() != s.charAt(i)) {
					st.push(s.charAt(i));
				}else {
					st.pop();
				}
			}
		}
		if(st.isEmpty()) {
			answer = 1;
		}else {
			answer = 0;
		}
    	return answer;
	}
}
