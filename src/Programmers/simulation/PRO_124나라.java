package simulation;

public class PRO_124나라 {

	public static void main(String[] args) {
		System.out.println(solution(3));
	}
	public static String solution(int n) {
        String answer = "";
        String [] num = {"4","1","2"};
        while(n > 0) {
        	int reminder = n%3;
        	n /= 3;
        	if(reminder == 0) n--;
        	answer = num[reminder] + answer;
        	
        }
        return answer;
    }
}
