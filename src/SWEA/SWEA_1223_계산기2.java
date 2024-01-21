package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 스택으로 구현  -> 우선 순위에 따라서 우선 곱셈 할 거 끼리 먼저
 * 곱셈 연산자들을 숫자 바로 뒤로 붙이고 서로 서로 곱하게 끔 배치 후 모든 두개의 숫자에 대해서 곱해지면 -> 더하기를 진행
 * 후위 연산식 완성
 * 그 후 계산시 바로 ans로 계산 할 수 없다.
 * 
 * 새로운 스택 이용 숫자용 스택으로 해당 연산자가 들어오면 순서대로 숫자에 종속적으로 돌아가게끔하자
 * -> 숫자 두개 빼서 연산자에 따라서 새로 넣고
 * -> 이를 지속적으로 반복해서 마지막 연산자에 대해서도 다 동작하면 마지막 하나의 들어오는 숫자가 마지막 답이 된다.
 * 
 * 
 */
public class SWEA_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int T = 1;T<11;T++)
		{
			Stack<Integer> num = new Stack<>();
			Stack<Character> op = new Stack<>();
			
			int N = Integer.parseInt(in.readLine());
			String post = "";
			String str = in.readLine();
			//후위 표기식 우선순위대로 만들기
			for(int i = 0;i<str.length();i++)
			{
				if(str.charAt(i) == '+' || str.charAt(i) == '*') {
					if(op.isEmpty()) {//비어있으면 조건돌 거 없이 바로 넣는다.
						op.add(str.charAt(i));
					}else { //다 우선 순위 비교가 필요하다.
						if((op.peek() == '*') && (str.charAt(i) =='+' || str.charAt(i) =='*')) {
							post+=op.pop();
							op.add(str.charAt(i));
						}else if((op.peek() == '+') && (str.charAt(i) =='+' || str.charAt(i) =='*')) {
							op.add(str.charAt(i));
						}
					}
				}
				else {
					post+=str.charAt(i);//숫자는 그냥 넣음
				}
			}
			while(!op.isEmpty()) {
				post+=op.pop();
			}
			for(int i = 0;i<post.length();i++)
			{
				if(post.charAt(i) != '+' && post.charAt(i) != '*')
				{
					num.add(post.charAt(i)-'0');//숫자일때 무조건 넣음
				}
				if(post.charAt(i)=='+') {
					int temp = num.pop()+num.pop();
					num.add(temp); //마찬가지로 넣은 연산자들끼리 연산 시킨뒤
				}
				if(post.charAt(i) =='*') {
					int temp = num.pop()*num.pop();
					num.add(temp);//해당 연산자이면 num에서 넣은거 두개빼서 * 두개 끼리 시키고
				}
			}
			//모든 연산자가 다 돌았으면 이미 맨 위에는 모든 연산자에 대한 계산이 다 된 값이 남아있어야 정상이다.
			System.out.println("#"+T+" "+num.pop());//제일 위의 값 즉 해답이 나오게 된다.
		}
	}
}
