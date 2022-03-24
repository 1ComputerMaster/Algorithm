package String;

public class PRO_KAKAO_숫자_문자열과_영단어 {

	public static void main(String[] args) {
		System.out.println(solution("zeroone234fivesixseven89"));
	}
	public static int solution(String s) {
		int answer = 0;
		String words[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String nums[] = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(words[i], nums[i]);
		}
		answer = Integer.parseInt(s);
		return answer;
    }
}
