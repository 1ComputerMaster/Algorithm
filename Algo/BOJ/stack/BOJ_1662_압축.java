package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662_압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String ans = "";
		Stack<Integer> len = new Stack<>(); //가로 앞 숫자
		Stack<Integer> mul = new Stack<>(); //곱해지는 수
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if(c=='('){
	            cnt-=1;
	            int mulNum = str.charAt(i-1)-'0'; // 얼마나 곱할 지
	            len.add(cnt); //확정된 길이가 들어감
	            mul.add(mulNum);//mulNum 저장하고
	            cnt=0;
	        }else if(c == ')') { //닫힌 괄호 나오면 그 mulNum을 뺀다.
	        	int val = mul.pop(); //숫자가 나옴
	        	val*= cnt; //자릿수 바로 곱함
	        	int plus = len.pop();//길이의 아웃
	        	cnt = val + plus;//괄호 앞에 있던 길이도 더해짐
	        }
	        else {
	        	cnt++;
	        }
		}
		System.out.println(cnt);
	}

}
