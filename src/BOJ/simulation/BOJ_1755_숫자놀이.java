package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1755_숫자놀이 {
	static String srr[];//글자 및 숫자를 저장하는 배열이 된다.
	public static void main(String[] args) throws IOException {
		//숫자 놀이
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 인풋스트림 리더로 기본 입력을 바꾼다.
		StringTokenizer tk = new StringTokenizer(in.readLine()," "); // 입력 받은 것을 공백으로나눈다
		int N = Integer.parseInt(tk.nextToken()); //스트링을 정수로 입력 받음
		int M = Integer.parseInt(tk.nextToken()); //스트링을 정수로 입력 받음
		int cnt = 0;//srr의 처음부터 저장하기 위해서
		srr  = new String[M-N+1]; //101로 써서 메모리를 마음껏  쓸 수 있으나 갯수에 딱 맞게 쓰기 위해서
		for (int i = N; i <= M; i++) { //N 부터 M까지 출력을 위해서
			String num = i +" ";//스트링으로 받는다 하나 하나 씩 나눠서 보려고
			String temp = ""; // 여기에 글자로 된 숫자를 저장하고
			for (int j = 0; j < num.length(); j++) {
				if(num.charAt(j) == '0') { //숫자를 글로 바꾸기 위함
					temp+="zero "; //제로
				}
				if(num.charAt(j) == '1') {//숫자를 글로 바꾸기 위함
					temp+="one ";
				}
				if(num.charAt(j) == '2') {//숫자를 글로 바꾸기 위함
					temp+="two ";
				}
				if(num.charAt(j) == '3') {//숫자를 글로 바꾸기 위함
					temp+="three ";
				}
				if(num.charAt(j) == '4') {//숫자를 글로 바꾸기 위함
					temp+="four ";
				}
				if(num.charAt(j) == '5') {//숫자를 글로 바꾸기 위함
					temp+="five ";
				}
				if(num.charAt(j) == '6') {//숫자를 글로 바꾸기 위함
					temp+="six ";
				}
				if(num.charAt(j) == '7') {//숫자를 글로 바꾸기 위함
					temp+="seven ";
				}
				if(num.charAt(j) == '8') {//숫자를 글로 바꾸기 위함
					temp+="eight ";
				}
				if(num.charAt(j) == '9') {//숫자를 글로 바꾸기 위함
					temp+="nine ";
				}
			}
			srr[cnt] = temp;//srr에는 이제 글로 저장된 숫자가 저장되어짐
			cnt++; //cnt는 0부터 저장하기 위함
		}
		Arrays.sort(srr); //정렬하므로써 다시 쓰게 된다 -> 글자순서대로
		cnt = 0;//다시 srr 0 부터 저장하려고
		for (int i = 0; i < srr.length; i++) { //N 부터 M까지 출력을 위해서
			tk = new StringTokenizer(srr[i]," "); // 다시 숫자로 바꾸기 위함 공백으로 취하고
			int size = tk.countTokens(); //크기
			String temp =""; //이것도 잠시 숫자를 저장하기 위함
			for (int j = 0; j < size; j++) {//size로 정해줘야 나중에 다시 계속 사이즈가 바뀌지 않는다.
				String str = tk.nextToken();//밑에서 바로 쓰면 tk계속 빠져서 예외처리됨
				if(str.equals("zero")) {//글자를 숫자로 바꾸기 위함 
					temp+="0"; //숫자로
				}
				if(str.equals("one")) {//글자를 숫자로 바꾸기 위함 
					temp+="1";
				}
				if(str.equals("two")) {//글자를 숫자로 바꾸기 위함 
					temp+="2";
				}
				if(str.equals("three")) {//글자를 숫자로 바꾸기 위함 
					temp+="3";
				}
				if(str.equals("four")) {//글자를 숫자로 바꾸기 위함 
					temp+="4";
				}
				if(str.equals("five")) {//글자를 숫자로 바꾸기 위함 
					temp+="5";
				}
				if(str.equals("six")) {//글자를 숫자로 바꾸기 위함 
					temp+="6";
				}
				if(str.equals("seven")) {//글자를 숫자로 바꾸기 위함 
					temp+="7";
				}
				if(str.equals("eight")) {//글자를 숫자로 바꾸기 위함 
					temp+="8";
				}
				if(str.equals("nine")) {//글자를 숫자로 바꾸기 위함 
					temp+="9";
				}
			}
			srr[cnt] = temp;//다 쓴 숫자는 배열에 저장한다
			cnt++;//다시 srr을 상승시켜 그 다음 것을 보게 한다. i 값으로 써도 무방하나 위에서 이미 cnt로 가져와서 그대로 옮겼다.
		}
		for (int i = 0; i < srr.length; i++) {//출력을 위한 반복
			System.out.print(srr[i]+" ");//개행없이 바로 출력
			if((i+1)%10==0) {//10개를 출력한 후에는 줄바꿈 
				System.out.println();
			}
		}
	}
}
