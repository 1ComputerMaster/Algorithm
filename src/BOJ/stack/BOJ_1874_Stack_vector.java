package BOJ.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_Stack_vector {
	static class Data{
		char c;
		int idx;
		public Data(char c, int idx) {
			this.c = c;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Data> s = new Stack<Data>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> q = new ArrayList<>();
		//Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(in.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력 라인  
		int idx = 0;
		/*for(int i = 0 ;i<N;i++) {
			int tem = Integer.parseInt(in.readLine());
			if(arr.contains(tem)) {
				bw.write("NO");
	        	bw.newLine();
	        	bw.flush();
	    		bw.close();
				return;
			}
			if(tem == N) {//MAX 값 찾기
				idx = i;
			}
			arr.add(tem);
		}	*/
		int cnt = 0;
		for(int i = 0;i<N;i++)
		{
			int size = Integer.parseInt(in.readLine());
			int temp = size;
			temp -= cnt;//
			while(temp-- > 0)
			{
				cnt++;
				s.push(new Data('+',cnt));
				q.add('+');
			}
			if(s.peek().idx == size) {//3
				s.pop();
				q.add('-');
			}
			else {
				bw.write("NO");
				bw.newLine();
				bw.flush();
				bw.close();
				return;
			}
		}
		int size = q.size();
		for(int i =0;i<size;i++) {
			bw.write(q.get(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
		
}
