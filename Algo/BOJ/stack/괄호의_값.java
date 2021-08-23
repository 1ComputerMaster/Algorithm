package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
 * 시간 초과가 뜬다... stack을 처음부터 끝까지 탐색해서 그런듯하다. -> 수정 필요
 * 
 * 
 * 
 * 
 */

public class 괄호의_값 {
	
	public static void main(String[] args) throws IOException {
		Stack<Character> s = new Stack();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in); 
		char current ='0';//임시
		char before = '0';//임시
		int ans = 1;
		//종료 조건들(완)
		String str = in.readLine();
		for(int i = 0;i<str.length(); i++)
		{
			current = str.charAt(i);
			if(s.isEmpty()==false) {
				if(s.peek() == '['&& current==')') //지금 있는 열린 괄호과 [ 인데 ) 이거 들어오면 안된다.
				{
					System.out.println(0);
					return;
				}
				if(s.peek() == '('&& current==']')
				{
					System.out.println(0);
					return;
				}
			}
			s.add(current);
		}
		int cnt = 0;
		boolean check = false;
		boolean check2 = false;
		int temp = 0;
		//다 넣고 나서는
		while(s.isEmpty()==false) { //다 나갈때 까지 반복문 돌림
			if(s.peek() == ')' && before == '0') { //현재 스택에 이거면)
				before = s.pop();
				cnt++;	//1
			}
			else if(s.peek() == ']' && before == '0') { //현재 스택에 이거면)
				before = s.pop();
				cnt++;
			}
			
			if(s.peek() ==')' && before == ')') {
				check = true;
				if(check2 == true) {
					check = false;
					check2 = false;
				}
				before = s.pop();
				ans*=2;
				cnt++;
			}
			else if(s.peek()==']'&&before == ']') {
				check = true;
				if(check2 == true) {
					check = false;
					check2 = false;
				}
				before = s.pop();
				ans*=3;
				cnt++;
			}
			else if(s.peek()==']'&&before == ')') {
				check = true;
				before = s.pop();//']'
				ans*=2;
				//cnt++;//2
			}
			else if(s.peek()==')'&&before == ']') {
				check = true;
				before = s.pop();
				ans*=3;
				//cnt++;//2
			}
			
			if(s.peek() =='(' && before == ')') {
				check = true;
				if(check2 == true) {
					check = false;
					check2 = false;
				}
				before = s.pop();
				ans+=2;
				cnt++;
			}
			else if(s.peek()=='['&&before == ']') {
				check = true;
				if(check2 == true) {
					check = false;
					check2 = false;
				}
				before = s.pop();
				ans+=3;
				cnt++;
			}
			
			if(s.peek()=='['&&before == ']' && check == true) {
				ans*=3;
				temp += ans;
				ans =1;
				check = false;
				for(int i = 0;i<cnt;i++) {//2개 뺌
					s.pop();
					before = ')';
				}
				check2 = true;
				if(s.peek() =='('||s.peek()=='[') {
					s.pop();
					check2 =false;
					before = '0';
				}
				cnt = 0;
			}
			else if(s.peek()=='('&&before == ')' && check == true) {
				ans*=2;
				temp += ans;
				ans= 1;
				check = false;
				for(int i = 0;i<cnt;i++) {
					s.pop();
					before = ']';
				}
				check2 = true;
				if(s.peek() =='('||s.peek()=='[') {
					s.pop();
					before = '0';
					check2 = false;
				}
				cnt = 0;
			}
			else if(s.peek()=='['&&before == ']' && check == false) {
				ans+=3;
				temp += ans;
				ans = 1;
				for(int i = 0;i<cnt;i++) {//2개 뺌
					s.pop();
					before = ')';
				}
				check2 = true;
				if(s.peek() =='('||s.peek()=='[') {
					s.pop();
					check2 =false;
					before = '0';
				}
				cnt = 0;
			}
			else if(s.peek()=='('&&before == ')' && check == false) {
				ans+=2;
				temp += ans;
				ans = 1;
				for(int i = 0;i<cnt;i++) {
					s.pop();
					before = ']';
				}
				check2 = true;
				if(s.peek() =='('||s.peek()=='[') {
					s.pop();
					before = '0';
					check2 = false;
				}
				cnt=0;
			}
		}
		System.out.println(temp);
	}
}
