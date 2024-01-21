package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 큐에 넣어서 셔플 되어진 것을 빼서 넣는것을 상상하였다.
 * 반 나눠서 큐에 넣었다가 다시 뺌
 * 
 */
public class Perfact_shuffle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<String> first = new LinkedList<String>();
		Queue<String> second = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case<=T;test_case++) {
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			st = new StringTokenizer(str," ");
			if(n%2==1) {//홀 수 
				for(int i = 0;i<=n/2;i++) {
					first.add(st.nextToken());
				}
				for(int i = n/2+1; i<n;i++) {
					second.add(st.nextToken());
				}
			}
			else {
				for(int i = 0;i<n/2;i++) {//0,1,2
					first.add(st.nextToken());
				}
				for(int i = n/2; i<n;i++) {//3,4,5
					second.add(st.nextToken());
				}
			}
			System.out.print("#"+test_case+" ");
			while(true)
			{
				if(first.isEmpty()==false)
				{
					System.out.print(first.poll()+" ");
				}
				if(second.isEmpty() == false) {
					System.out.print(second.poll()+" ");
				}
				if(first.isEmpty() && second.isEmpty()) {
					System.out.println();
					break;
				}
			}
		}
	}
}
